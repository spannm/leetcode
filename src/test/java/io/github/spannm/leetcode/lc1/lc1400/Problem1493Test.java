package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1493Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,1,0,1; 3",
        "0,1,1,1,0,1,1,0,1; 5",
        "1,1,1; 2",
        "1,1,0,0,1,1,1,0,1; 4",
        "0,0,1,1; 2",
        "1,0,1,1,1,1,1,1,0,1,1,1,1,1; 11"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1493().longestSubarray(_nums));
    }

}
