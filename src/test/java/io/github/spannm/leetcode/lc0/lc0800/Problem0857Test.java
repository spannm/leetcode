package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0857Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "10,20,5; 70,50,30,; 2; 105.00",
        "3,1,10,10,1; 4,8,2,2,7; 3; 30.66667"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _quality,
        @ConvertWith(CsvToIntArray.class) int[] _wage,
        int _k,
        double _expectedResult) {
        assertEquals(_expectedResult, new Problem0857().mincostToHireWorkers(_quality, _wage, _k), 0.00001);
    }

}
