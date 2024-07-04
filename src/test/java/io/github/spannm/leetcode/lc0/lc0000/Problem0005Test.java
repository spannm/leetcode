package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0005Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "babad; aba",
        "cbbd; bb"
    })
    void test(
        String _s,
        String _expectedResult) {
        assertEquals(_expectedResult, new Problem0005().longestPalindrome(_s));
    }

}
