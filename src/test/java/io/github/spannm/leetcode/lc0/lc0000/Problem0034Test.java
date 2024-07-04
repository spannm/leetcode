package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0034Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5,7,7,8,8,10; 8; 3,4",
        "5,7,7,8,8,10; 6; -1,-1",
        "; 0; -1,-1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _target,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0034().searchRange(_nums, _target));
    }
}
