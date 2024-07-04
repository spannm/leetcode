package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2958Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,1,2,3,1,2; 2; 6",
        "1,2,1,2,1,2,1,2; 1; 2",
        "5,5,5,5,5,5,5; 4; 4"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] nums, int k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem2958().maxSubarrayLength(nums, k));
    }

}
