package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0239Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "1,3,-1,-3,5,3,6,7; 3; 3,3,5,5,6,7",
        "1; 1; 1"
    })

    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _k,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0239().maxSlidingWindow(_nums, _k));
    }

}
