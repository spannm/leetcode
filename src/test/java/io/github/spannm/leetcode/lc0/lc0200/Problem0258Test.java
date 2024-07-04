package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0258Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "38; 2",
        "0; 0",
        "9; 9",
        "10; 1"
    })
    void test(
        int _num,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0258().addDigits(_num));
    }

}
