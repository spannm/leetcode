package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0330Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3; 6; 1",
        "1,5,10; 20; 2",
        "1,2,2; 5; 0"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _n, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0330().minPatches(_nums, _n));
    }
}