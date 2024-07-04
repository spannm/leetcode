package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0564Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "123; 121",
        "1; 0",
        "10; 9"
    })
    void test(String _n, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0564().nearestPalindromic(_n));
    }

}
