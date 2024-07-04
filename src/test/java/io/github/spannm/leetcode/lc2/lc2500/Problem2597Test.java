package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2597Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2,4,6; 2; 4",
        "1; 1; 1"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem2597().beautifulSubsets(_nums, _k));
    }
}

