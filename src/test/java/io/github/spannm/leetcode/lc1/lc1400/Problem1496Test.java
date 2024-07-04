package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1496Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "NES; false",
        "NESWW; true"
    })
    void test(String arg0, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem1496().isPathCrossing(arg0));
    }
}
