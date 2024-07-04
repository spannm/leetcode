package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0020Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource(delimiter = ';', value = {
        "(); true",
        "()[]{}; true",
        "(]; false",
        "[; false",
        "((; false"
    })
    void test(String _input, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0020().isValid(_input));
    }

}
