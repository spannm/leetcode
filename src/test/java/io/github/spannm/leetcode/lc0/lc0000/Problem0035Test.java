package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0035Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, target {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[1,3,5,6]; 5; 2",
        "[1,3,5,6]; 2; 1",
        "[1,3,5,6]; 7; 4",
        "[1]; 1; 0",
        "[1,3,5]; 4; 2",
        "[1,3,5]; 5; 2",
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _target,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0035().searchInsert(_nums, _target));
    }

}
