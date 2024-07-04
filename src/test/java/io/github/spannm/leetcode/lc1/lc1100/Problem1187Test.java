package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1187Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,5,3,6,7; 1,3,2,4; 1",
        "1,5,3,6,7; 4,3,1; 2",
        "1,5,3,6,7; 1,6,3,3; -1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _arr1,
        @ConvertWith(CsvToIntArray.class) int[] _arr2,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem1187.makeArrayIncreasing(_arr1, _arr2));
    }

}
