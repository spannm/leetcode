package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0003Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "; 0",
        "x; 1",
        "abcabcbb; 3",
        "bbbbb; 1",
        "pwwkew; 3",
        "au; 2",
        "dvdf; 3"
    })
    void test(String _input, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0003().lengthOfLongestSubstring(_input));
    }

}
