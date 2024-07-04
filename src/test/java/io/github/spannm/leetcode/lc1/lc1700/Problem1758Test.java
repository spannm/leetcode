package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1758Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "0100; 1",
        "10; 0",
        "1111; 2"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1758().minOperations(_s));
    }
}
