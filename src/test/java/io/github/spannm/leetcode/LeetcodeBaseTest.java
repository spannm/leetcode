package io.github.spannm.leetcode;

import io.github.spannm.leetcode.dep.ListNode;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.converter.TypedArgumentConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeetcodeBaseTest extends Assertions {

    /** The slf4j logger. */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected final Logger getLogger() {
        return logger;
    }

    @SuppressWarnings("unchecked")
    static <T> T[] createArray(Class<T> _clazz, int _capacity) {
        return (T[]) Array.newInstance(_clazz, _capacity);
    }

    @SuppressWarnings("unchecked")
    static <T, R extends T> IntFunction<R[]> genericArray(IntFunction<T[]> _arrayCreator) {
        return size -> (R[]) _arrayCreator.apply(size);
    }

    static String[][] convertCsvToStringMatrix(Object _csv) {
        if (_csv == null) {
            return new String[0][];
        }
        String csv = _csv.toString();
        if (csv.isBlank()) {
            return new String[0][];
        }
        Matcher m = Pattern.compile("(\\[?\s*[^\\[\\]]*\\])\s*?", Pattern.MULTILINE | Pattern.DOTALL).matcher(csv);
        List<String[]> l = new ArrayList<>();
        while (m.find()) {
            String found = m.group(1);
            if (found.isEmpty() || "[]".equals(found)) {
                l.add(new String[0]);
            } else {
                found = found.substring(1, found.length() - 1);
                String[] split = found.split("\s*,\s*");
                for (int i = 0; i < split.length; i++) {
                    if ("null".equalsIgnoreCase(split[i])) {
                        split[i] = null;
                    }
                }
                l.add(split);
                csv = m.group(1);
            }
        }
        return l.toArray(new String[0][]);
    }

    public static final class CsvToIntArray extends TypedArgumentConverter<String, int[]> {
        CsvToIntArray() {
            super(String.class, int[].class);
        }

        @Override
        protected int[] convert(String _source) {
            List<Integer> list = new CsvToIntegerList().convert(_source);
            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    public static final class CsvToIntegerList extends TypedArgumentConverter<String, List<Integer>> {
        @SuppressWarnings("unchecked")
        CsvToIntegerList() {
            super(String.class, (Class<List<Integer>>) (Object) List.class);
        }

        @Override
        protected List<Integer> convert(String _source) {
            if (_source == null || _source.isBlank() || "[]".equals(_source.trim())) {
                return List.of();
            }

            Path p = Path.of(_source);
            if (Files.exists(p)) {
                try (Stream<String> lines = Files.lines(p)) {
                    return lines.filter(Objects::nonNull).map(Integer::valueOf).toList();
                } catch (IOException _ex) {
                    throw new ArgumentConversionException("Failed to read file " + _source, _ex);
                }
            }

            Matcher m = Pattern.compile("\\[?([\\-0-9, (?:null)]+)\\]?").matcher(_source);
            if (m.matches()) {
                _source = m.group(1);
            }
            return Arrays.stream(_source.split("\\s*,\\s*"))
                .map(s -> "null".equalsIgnoreCase(s) ? null : Integer.parseInt(s))
                .toList();
        }
    }

    public static final class CsvToDoubleArray extends TypedArgumentConverter<String, double[]> {
        CsvToDoubleArray() {
            super(String.class, double[].class);
        }

        @Override
        protected double[] convert(String _source) {
            return new CsvToStringList().convert(_source).stream()
                .map(Double::parseDouble).mapToDouble(d -> d).toArray();
        }
    }

    public static final class CsvToDoubleList extends TypedArgumentConverter<String, List<Double>> {
        @SuppressWarnings("unchecked")
        CsvToDoubleList() {
            super(String.class, (Class<List<Double>>) (Object) List.class);
        }

        @Override
        protected List<Double> convert(String _source) {
            return new CsvToStringList().convert(_source).stream().map(Double::parseDouble).toList();
        }
    }

    public static final class CsvToBooleanList extends TypedArgumentConverter<String, List<Boolean>> {
        @SuppressWarnings("unchecked")
        CsvToBooleanList() {
            super(String.class, (Class<List<Boolean>>) (Object) List.class);
        }

        @Override
        protected List<Boolean> convert(String _source) {
            return new CsvToStringList().convert(_source).stream().map(Boolean::parseBoolean).toList();
        }
    }

    public static final class CsvToStringArray extends TypedArgumentConverter<String, String[]> {
        CsvToStringArray() {
            super(String.class, String[].class);
        }

        @Override
        protected String[] convert(String _source) {
            return _source == null || _source.isBlank() ? new String[0] : _source.split("\\s*,\\s*", -1);
        }
    }

    public static final class CsvToStringList extends TypedArgumentConverter<String, List<String>> {
        @SuppressWarnings("unchecked")
        CsvToStringList() {
            super(String.class, (Class<List<String>>) (Object) List.class);
        }

        @Override
        protected List<String> convert(String _source) {
            return Arrays.asList(new CsvToStringArray().convert(_source));
        }
    }

    public static final class CsvToCharArray extends TypedArgumentConverter<String, char[]> {
        CsvToCharArray() {
            super(String.class, char[].class);
        }

        @Override
        protected char[] convert(String _source) {
            String[] arrStr = new CsvToStringArray().convert(_source);
            char[] arr = new char[arrStr.length];
            for (int i = 0; i < arrStr.length; i++) {
                arr[i] = arrStr[i].charAt(0);
            }
            return arr;
        }
    }

    public static final class CsvToIntMatrix extends SimpleArgumentConverter {
        @Override
        protected int[][] convert(Object _source, Class<?> _targetType) {
            return Arrays.stream(convertCsvToStringMatrix(_source))
                .map(strArr -> Arrays.stream(strArr).map(Integer::parseInt).mapToInt(i -> i).toArray()).toList().toArray(new int[0][]);
        }
    }

    public static final class CsvToIntegerMatrix extends SimpleArgumentConverter {
        @Override
        protected Integer[][] convert(Object _source, Class<?> _targetType) {
            return Arrays.stream(convertCsvToStringMatrix(_source))
                .map(strArr -> Arrays.stream(strArr).map(i -> i == null ? null : Integer.valueOf(i)).toArray(Integer[]::new)).toList().toArray(new Integer[0][]);
        }
    }

    public static final class CsvToCharMatrix extends SimpleArgumentConverter {
        @Override
        public char[][] convert(Object _source, Class<?> _targetType) {
            String[][] strMatrix = convertCsvToStringMatrix(_source);
            List<char[]> l = new ArrayList<>();
            for (String[] arrStr : strMatrix) {
                char[] arrChar = new char[arrStr.length];
                for (int i = 0; i < arrStr.length; i++) {
                    arrChar[i] = arrStr[i].charAt(0);
                }
                l.add(arrChar);
            }
            return l.toArray(new char[0][]);
        }
    }

    public static final class CsvToStringMatrix extends SimpleArgumentConverter {
        @Override
        protected String[][] convert(Object _source, Class<?> _targetType) {
            return convertCsvToStringMatrix(_source);
        }
    }

    public static final class CsvToListOfStringLists extends SimpleArgumentConverter {
        @Override
        protected List<List<String>> convert(Object _source, Class<?> _targetType) {
            String[][] arr = convertCsvToStringMatrix(_source);
            return Arrays.stream(arr).map(a -> Stream.of(a).toList()).toList();
        }
    }

    public static final class CsvToListOfIntegerLists extends SimpleArgumentConverter {
        @Override
        protected List<List<Integer>> convert(Object _source, Class<?> _targetType) {
            int[][] arr = new CsvToIntMatrix().convert(_source, _targetType);
            return Arrays.stream(arr)
                .map(Arrays::stream)
                .map(IntStream::boxed)
                .map(a -> a.collect(Collectors.toList()))
                .collect(Collectors.toList());
        }
    }

    public static class CsvToListNode extends TypedArgumentConverter<String, ListNode> {
        CsvToListNode() {
            super(String.class, ListNode.class);
        }

        @Override
        protected ListNode convert(String _source) {
            return convertCsvToListNode(_source);
        }

        static ListNode convertCsvToListNode(String _s) {
            String s = Optional.ofNullable(_s).orElse("")
                .trim().replace("[", "").replace("]", "");

            if (s.isBlank()) {
                return null;
            }

            List<Long> longs = Arrays.stream(s.split(" *, *")).map(Long::parseLong).collect(Collectors.toList());
            Collections.reverse(longs);

            ListNode ln = null;
            for (long l : longs) {
                if (l > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException("Integer overflow");
                }
                ln = new ListNode((int) l, ln);
            }

            return ln;
        }
    }

    public static class CsvToListNodeArray extends SimpleArgumentConverter {
        @Override
        protected ListNode[] convert(Object _source, Class<?> _targetType) {
            String[][] strMatrix = convertCsvToStringMatrix(_source);
            ListNode[] arrListNodes = new ListNode[strMatrix.length];
            for (int i = 0; i < strMatrix.length; i++) {
                arrListNodes[i] = CsvToListNode.convertCsvToListNode(String.join(",", strMatrix[i]));
            }
            return arrListNodes;
        }
    }

    public static final class CsvToTreeNode extends TypedArgumentConverter<String, TreeNode> {
        CsvToTreeNode() {
            super(String.class, TreeNode.class);
        }
        @Override
        protected TreeNode convert(String _source) {
            List<Integer> list = new CsvToIntegerList().convert(_source);
            return TreeNode.createTree(list);
        }
    }

    public static final class CsvToListOfTreeNodes extends SimpleArgumentConverter {
        @Override
        protected List<TreeNode> convert(Object _source, Class<?> _targetType) {
            Integer[][] arr = new CsvToIntegerMatrix().convert(_source, _targetType);
            List<TreeNode> l = new ArrayList<>(arr.length);
            for (Integer[] ai : arr) {
                TreeNode tn = TreeNode.createTree(Arrays.stream(ai).toList());
                if (tn != null) {
                    l.add(tn);
                }
            }
            return l;
        }
    }

}
