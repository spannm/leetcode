package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0516Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource(delimiter = ';', value = {
        "bbbab; 4",
        "cbbd; 2"
    })
    void test(
        String _str,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0516().longestPalindromeSubseq(_str));
    }

}
