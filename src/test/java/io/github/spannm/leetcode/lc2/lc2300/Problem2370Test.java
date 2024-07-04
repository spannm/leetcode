package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2370Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "acfgbd; 2; 4",
        "abcd; 3; 4"
    })
    void test(String _s, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem2370().longestIdealString(_s, _k));
    }

}
