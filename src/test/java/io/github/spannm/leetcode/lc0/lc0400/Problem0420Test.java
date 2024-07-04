package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0420Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource(delimiter = ';', value = {
        "a; 5",
        "aA1; 3",
        "1337C0d3; 0",
        "1Aaaaaaa_xX; 2",
        "aaa123; 1",
        "bbaaaaaaaaaaaaaaacccccc; 8",
        "bbaaaaaaaaaaaaaaaccc; 6"
    })
    void test(String _password, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0420().strongPasswordChecker(_password));
    }

}
