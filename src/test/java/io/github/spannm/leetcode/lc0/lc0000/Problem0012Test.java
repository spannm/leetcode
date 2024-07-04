package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0012Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3; III",
        "58; LVIII",
        "1994; MCMXCIV",
        "2000; MM",
        "600; DC"
    })
    void test(int _input, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0012().intToRoman(_input));
    }

}
