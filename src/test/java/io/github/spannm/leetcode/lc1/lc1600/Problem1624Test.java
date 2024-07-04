package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1624Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "aa; 0",
        "abca; 2",
        "cbzxy; -1"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1624().maxLengthBetweenEqualCharacters(_s));
    }

}
