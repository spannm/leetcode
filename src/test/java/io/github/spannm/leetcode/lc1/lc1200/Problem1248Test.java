package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1248Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,1,2,1,1; 3; 2",
        "2,4,6; 1 ; 0",
        "2,2,2,1,2,2,1,2,2,2; 2; 16"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1248().numberOfSubarrays(_nums, _k));
    }
}
