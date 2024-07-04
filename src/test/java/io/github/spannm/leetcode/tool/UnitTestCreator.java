package io.github.spannm.leetcode.tool;

import com.squareup.javapoet.*;
import com.squareup.javapoet.MethodSpec.Builder;
import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.LeetcodeBaseTest.CsvToStringList;
import io.github.spannm.leetcode.LeetcodeRuntimeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

/**
 * Code generator for single or multiple unit tests based on the first public method in the specified Leetcode problem.
 *
 * @author Markus Spann
 */
public final class UnitTestCreator extends AbstractTool {

    private static final Pattern PROBLEM_PATTERN = Pattern.compile("Problem[0-9]{4}");

    private final Path           projectRoot;
    private final boolean        overwrite;

    UnitTestCreator() {
        projectRoot = getProjectRoot();
        overwrite = false;
    }

    public static void main(String[] _args) {

        List<String> args = Arrays.stream(_args).filter(Objects::nonNull).collect(Collectors.toList());

        if (args.isEmpty()) {
            String javaFile = selectFile();
            if (javaFile != null) {
                args.add(javaFile);
            } else if (PROBLEM_PATTERN != null) {
                IntStream.rangeClosed(1, 150)
                    .mapToObj(n -> String.format("Problem%04d", n))
                    .filter(n -> PROBLEM_PATTERN.matcher(n).matches())
                    .forEach(args::add);
            } else {
                return;
            }
        }

        try {
            UnitTestCreator creator = new UnitTestCreator();

            for (String arg : args) {
                creator.createUnitTest(arg);
            }
        } catch (Throwable _ex) {
            throw LeetcodeRuntimeException.from(_ex);
        }

    }

    static String selectFile() {
        return JOptionPane.showInputDialog(null,
            "Class to create unit test for:",
            UnitTestCreator.class.getSimpleName(),
            JOptionPane.QUESTION_MESSAGE);
    }

    boolean createUnitTest(String _className) throws IOException {
        return createUnitTest(findClass(_className));
    }

    boolean createUnitTest(Class<?> _clazz) throws IOException {
        Path sourceFile = findSourceFile(_clazz, projectRoot);

        Path testSourceFile = getTestSourceFile(sourceFile);

        if (!overwrite && Files.exists(testSourceFile) && Files.size(testSourceFile) > 0) {
            getLogger().warn("Unit test '{}' exists and is non-empty", testSourceFile);
            return false;
        }

        Path dir = testSourceFile.getParent();
        if (!Files.exists(dir)) {
            getLogger().info("Creating directory {}", dir);
            try {
                Files.createDirectories(dir);
            } catch (IOException _ex) {
                throw new LeetcodeRuntimeException("Could not create direcctory " + dir, _ex);
            }
        }

        Method method = findTestMethod(_clazz);

        String methodParms = IntStream.range(0, method.getParameterCount()).mapToObj(i -> "{" + i + "}").collect(Collectors.joining("; "));
        String expectedParm = "{" + method.getParameterCount() + "}";
        AnnotationSpec annotParameterizedTest = AnnotationSpec.builder(ParameterizedTest.class)
            .addMember("name", CodeBlock.of("\"[{index}] " + methodParms + " --> " + expectedParm + "\""))
            .build();
        AnnotationSpec annotCsvSource = AnnotationSpec.builder(CsvSource.class)
            .addMember("delimiter", CodeBlock.of("';'"))
            .addMember("value", CodeBlock.of("{\"\"}"))
            .build();

        Builder testMethodBuilder = MethodSpec.methodBuilder("test")
            .returns(void.class)
            .addAnnotation(annotParameterizedTest)
            .addAnnotation(annotCsvSource);

        for (Parameter parm : method.getParameters()) {
            ParameterSpec.Builder parmBuilder = ParameterSpec.builder(parm.getType(), parm.getName());
            Optional.ofNullable(findCsvConverterClass(parm.getType())).ifPresent(
                c -> parmBuilder.addAnnotation(AnnotationSpec.builder(ConvertWith.class)
                    .addMember("value", CodeBlock.of("$T.class", c))
                    .build()));
            testMethodBuilder.addParameter(parmBuilder.build());
        }

        boolean isVoidReturn = method.getReturnType() == void.class;
        Class<?> returnType = isVoidReturn ? method.getParameters()[0].getType() : method.getReturnType();
        ParameterSpec.Builder returnBuilder = ParameterSpec.builder(returnType, "_expectedResult");
        Optional.ofNullable(findCsvConverterClass(returnType)).ifPresent(
            c -> returnBuilder.addAnnotation(AnnotationSpec.builder(ConvertWith.class)
                .addMember("value", CodeBlock.of("$T.class", c))
                .build()));
        testMethodBuilder.addParameter(returnBuilder.build());

        if (isVoidReturn) {
            testMethodBuilder.addStatement("new $T().$L($L)",
                method.getDeclaringClass(), method.getName(),
                Arrays.stream(method.getParameters()).map(Parameter::getName)
                    .collect(Collectors.joining(", ")));
            testMethodBuilder.addStatement("$L(_expectedResult, $L)",
                returnType.isArray() ? "assertArrayEquals" : "assertEquals",
                method.getParameters()[0].getName());
        } else {
            testMethodBuilder.addStatement("$L(_expectedResult, new $T().$L($L))",
                returnType.isArray() ? "assertArrayEquals" : "assertEquals",
                _clazz, method.getName(),
                Arrays.stream(method.getParameters()).map(Parameter::getName)
                    .collect(Collectors.joining(", ")));
        }

        TypeSpec testClass = TypeSpec.classBuilder(_clazz.getSimpleName() + "Test")
            .superclass(LeetcodeBaseTest.class)
            .addMethod(testMethodBuilder.build())
            .build();

        JavaFile javaFile = JavaFile.builder(_clazz.getPackage().getName(), testClass)
            .skipJavaLangImports(true)
            .indent("    ")
            .build();

        try {
            StringBuilder sb = new StringBuilder();
            javaFile.writeTo(sb);
            String source = sb.toString().replace("LeetcodeBaseTest.CsvTo", "CsvTo");
            Files.writeString(testSourceFile, source, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            getLogger().info("Wrote unit test {}", testSourceFile);
        } catch (IOException _ex) {
            throw new LeetcodeRuntimeException("Could not write unit test " + testSourceFile, _ex);
        }

        return true;
    }

    Method findTestMethod(Class<?> _clazz) {
        List<Method> list = Arrays.stream(_clazz.getDeclaredMethods().length > 0 ? _clazz.getDeclaredMethods()
            : Arrays.stream(_clazz.getDeclaredClasses())
                .filter(c -> Modifier.isStatic(c.getModifiers()))
                .map(Class::getDeclaredMethods)
                .filter(arr -> arr.length > 0)
                .findFirst().orElseThrow(
                    () -> new LeetcodeRuntimeException("No non-static methods found in inner classes of " + _clazz)))
            .filter(m -> !Modifier.isStatic(m.getModifiers()))
            .filter(m -> !Modifier.isPrivate(m.getModifiers())).collect(Collectors.toCollection(ArrayList::new));
        return IntStream.rangeClosed(1, list.size())
            .mapToObj(i -> list.get(list.size() - i)) // establish order of methods in source code
            .min(Comparator.comparingInt(Method::getModifiers)
                // prioritize non-void return types
                .thenComparing((m1, m2) -> Integer.compare(m1.getReturnType() == void.class ? -1 : 1, m2.getReturnType() == void.class ? -1 : 1)))
            .orElseThrow(() -> new LeetcodeRuntimeException("No non-static non-private method found in " + _clazz));
    }

    @SuppressWarnings("unchecked")
    Class<? extends ArgumentConverter> findCsvConverterClass(Class<?> _class) {
        String className = _class.getSimpleName()
            .replace("[][]", "Matrix")
            .replace("[]", "Array");
        className = LeetcodeBaseTest.class.getName() + "$CsvTo" + className.substring(0, 1).toUpperCase() + className.substring(1);
        try {
            return (Class<? extends ArgumentConverter>) Class.forName(className);
        } catch (ClassNotFoundException _ex) {
            if (_class == List.class) {
                // generics type erasure prevents selecting the appropriate converter
                return CsvToStringList.class;
            }
        }
        return null;
    }

    Path getTestSourceFile(Path _sourceFile) {
        char sep = File.separatorChar;
        String name = _sourceFile.toString().replace("src" + sep + "main" + sep + "java", "src" + sep + "test" + sep + "java").replaceAll("(\\.java)$", "Test$1");
        return Path.of(name);
    }

    Path getProjectRoot() {
        try {
            Path path = Path.of(getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
            while (path.getNameCount() > 0 && path.getName(path.getNameCount() - 1).toString().matches("^(?:target|(?:test-)?classes)$")) {
                path = path.getParent();
            }
            return path;
        } catch (URISyntaxException _ex) {
            throw new LeetcodeRuntimeException("Could not get path of project root", _ex);
        }
    }

    Class<?> findClass(String _name) {
        String name = _name;
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException _ex) {
            if (name.matches("^[0-9]{1,4}$")) {
                name = String.format("Problem%04d", Long.valueOf(name));
            }
            Pattern problemPattern = Pattern.compile("^Problem([0-9])([0-9])([0-9]+)$");
            Matcher matcher = problemPattern.matcher(name);
            if (matcher.matches()) {
                try {

                    name = "io.github.spannm.leetcode.lc"
                        + matcher.group(1) + ".lc" + matcher.group(1) + matcher.group(2) + "00." + name;
                    return Class.forName(name);

                } catch (ClassNotFoundException _ex1) {
                    matcher = null;
                }
            }

        }
        throw new LeetcodeRuntimeException("Could not find class for " + name);
    }

    Path findSourceFile(Class<?> _clazz, Path _projectRoot) {
        String fileName = _clazz.getSimpleName() + ".java";
        try (Stream<Path> walk = Files.walk(_projectRoot)) {
            return walk.filter(Files::isRegularFile)
                .filter(Files::isReadable)
                .filter(f -> f.getFileName().toString().endsWith(fileName))
                .findFirst().orElseThrow();
        } catch (IOException _ex) {
            throw new LeetcodeRuntimeException("Could not find source file for class " + _clazz, _ex);
        }
    }

}
