package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0151Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "the sky is blue; blue is sky the",
        "  hello world  ; world hello",
        "a good   example; example good a"
    })
    void test(String _s, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0151().reverseWords(_s));
    }

}
