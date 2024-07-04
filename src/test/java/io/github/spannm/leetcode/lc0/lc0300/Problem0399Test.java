package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0399Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}], {2} --> [{3}]")
    @CsvSource(delimiter = ';', value = {
        "[a,b],[b,c]; 2.0,3.0; [a,c],[b,a],[a,e],[a,a],[x,x]; 6.00000,0.50000,-1.00000,1.00000,-1.00000"
    })
    void test(
        @ConvertWith(CsvToListOfStringLists.class) List<List<String>> _equations,
        @ConvertWith(CsvToDoubleArray.class) double[] _values,
        @ConvertWith(CsvToListOfStringLists.class) List<List<String>> _queries,
        @ConvertWith(CsvToDoubleArray.class) double[] _expectedResult) {

        assertArrayEquals(_expectedResult, Problem0399.calcEquation(_equations, _values, _queries));

    }

}
