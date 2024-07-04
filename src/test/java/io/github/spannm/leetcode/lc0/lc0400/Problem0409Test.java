package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0409Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "abccccdd; 7",
        "a; 1",
        "AAAAAA; 6"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0409().longestPalindrome(_s));
    }

}
