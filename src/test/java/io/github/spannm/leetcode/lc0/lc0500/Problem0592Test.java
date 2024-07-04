package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0592Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "-1/2+1/2; 0/1",
        "-1/2+1/2+1/3; 1/3",
        "1/3-1/2; -1/6"
    })
    void test(String _expr, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0592().fractionAddition(_expr));
    }

}
