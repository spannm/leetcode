package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1404Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1101; 6",
        "10; 1",
        "1; 0"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1404().numSteps(_s));
    }

}
