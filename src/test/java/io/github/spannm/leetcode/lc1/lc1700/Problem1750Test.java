package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1750Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "ca; 2",
        "cabaabac; 0",
        "aabccabba; 3"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1750().minimumLength(_s));
    }

}
