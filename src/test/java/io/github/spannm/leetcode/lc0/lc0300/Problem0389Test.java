package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0389Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "abcd; abcde; e",
        "''; y; y"
    })
    void test(
        String _s,
        String _t,
        char _expectedResult) {

        assertEquals(_expectedResult, new Problem0389().findTheDifference(_s, _t));
    }

}
