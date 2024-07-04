package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0008Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource(delimiter = ';', ignoreLeadingAndTrailingWhitespace = false, value = {
        "42;42",
        "   -42;-42",
        "4193 with words;4193",
        "words and 987;0",
        "-91283472332;-2147483648",
        ";0",
    })
    void test(String _input, long _expectedResult) {
        assertEquals(_expectedResult, new Problem0008().myAtoi(_input));
    }

}
