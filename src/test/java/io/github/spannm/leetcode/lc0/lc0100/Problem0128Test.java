package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0128Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "100,4,200,1,3,2; 4",
        "0,3,7,2,5,8,4,6,0,1; 9"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0128().longestConsecutive(_nums));
    }

}
