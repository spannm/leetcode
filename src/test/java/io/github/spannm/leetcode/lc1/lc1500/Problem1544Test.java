package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1544Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "leEeetcode; leetcode",
        "abBAcC; ''",
        "s; s"
    })
    void test(String _s, String _expectedResult) {
        assertEquals(_expectedResult, new Problem1544().makeGood(_s));
    }

}
