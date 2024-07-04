package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0454Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2}; {3} --> {4}")
    @CsvSource(delimiter = ';', value = {
        "1,2; -2,-1; -1,2; 0,2; 2",
        "0; 0; 0; 0; 1",
        "-1,-1; -1,1; -1,1; 1,-1; 6"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums1,
        @ConvertWith(CsvToIntArray.class) int[] _nums2,
        @ConvertWith(CsvToIntArray.class) int[] _nums3,
        @ConvertWith(CsvToIntArray.class) int[] _nums4, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0454().fourSumCount(_nums1, _nums2, _nums3, _nums4));
    }

}
