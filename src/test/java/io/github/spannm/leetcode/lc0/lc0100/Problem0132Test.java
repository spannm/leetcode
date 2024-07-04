package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0132Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "aab; 1",
        "a; 0",
        "ab; 1"
    })
    void test(String _str, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0132().minCut(_str));
    }

}
