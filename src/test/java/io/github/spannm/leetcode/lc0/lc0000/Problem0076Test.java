package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0076Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "ADOBECODEBANC; ABC; BANC",
        "a; a; a",
        "a; aa; ''"
    })
    void test(String _s, String _t, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0076().minWindow(_s, _t));
    }

}
