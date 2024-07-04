package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0167Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], target {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "2,7,11,15; 9; 1,2",
        "2,3,4; 6; 1,3",
        "-1,0; -1; 1,2",
        "5,25,75; 100; 2,3"
    })

    void test(
        @ConvertWith(CsvToIntArray.class) int[] _numbers,
        int _target,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0167().twoSum(_numbers, _target));
    }

}
