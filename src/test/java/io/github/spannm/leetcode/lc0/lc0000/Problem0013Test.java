package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0013Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "III; 3",
        "LVIII; 58",
        "MCMXCIV; 1994",
        "MM; 2000",
        "DC; 600"
    })
    void test(String _input, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0013().romanToInt(_input));
    }

}
