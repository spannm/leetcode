package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2962Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3,2,3,3; 2; 6",
        "1,4,2,1; 3; 0"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] nums, int k, long _expectedResult) {
        assertEquals(_expectedResult, new Problem2962().countSubarrays(nums, k));
    }

}
