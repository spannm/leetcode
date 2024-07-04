package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2444Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, target {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3,5,2,7,5; 1; 5; 2", // The fixed-bound subarrays are [1,3,5] and [1,3,5,2]
        "1,1,1,1; 1; 1; 10" // Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _minK,
        int _maxK,
        long _expectedResult) {

        assertEquals(_expectedResult, new Problem2444().countSubarrays(_nums, _minK, _maxK));
    }

}
