package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0029Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "10; 3; 3",
        "7; -3; -2"
    })
    void test(int _dividend, int _divisor, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0029().divide(_dividend, _divisor));
    }

}
