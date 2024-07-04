package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2485Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "8; 6",
        "1; 1",
        "4; -1"
    })
    void test(int n, int _expectedResult) {
        assertEquals(_expectedResult, new Problem2485().pivotInteger(n));
    }

}
