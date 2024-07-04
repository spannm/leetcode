package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0060Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "3; 3; 213",
        "4; 9; 2314",
        "3; 1; 123"
    })
    void test(int _n, int _k, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0060().getPermutation(_n, _k));
    }

}
