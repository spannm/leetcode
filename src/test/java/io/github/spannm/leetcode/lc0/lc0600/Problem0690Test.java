package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc0.lc0600.Problem0690.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Problem0690Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[1,5,[2,3]],[2,3,[]],[3,3,[]]; 1; 11",
        "[1,2,[5]],[5,-3,[]]; 5; -3"
    })
    void test(
        @ConvertWith(CsvToEmployeeList.class) List<Employee> _employees,
        int _id,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0690().getImportance(_employees, _id));
    }

    static final class CsvToEmployeeList extends SimpleArgumentConverter {
        @Override
        protected List<Employee> convert(Object _source, Class<?> _targetType) throws ArgumentConversionException {
            Pattern patt = Pattern.compile("\\[([0-9]+),([\\-0-9]+),\\[([0-9,]*)\\]{2}");
            Matcher matcher = patt.matcher((String) _source);
            List<Employee> employees = new ArrayList<>();
            while (matcher.find()) {
                List<Integer> subOrdinates = Arrays.stream(matcher.group(3).split(",")).filter(s -> !s.isBlank()).map(Integer::parseInt).toList();
                Employee employee = new Employee(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), subOrdinates);
                employees.add(employee);
            }
            return employees;
        }
    }

}
