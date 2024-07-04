package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0480Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3,-1,-3,5,3,6,7; 3; 1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000",
        "1,2,3,4,2,3,1,4,2; 3; 2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _k,
        @ConvertWith(CsvToDoubleArray.class) double[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0480().medianSlidingWindow(_nums, _k));
    }

}
