package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2466Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, {2}, {3} --> {4}")
    @CsvSource(delimiter = ';', value = {
        "3;3;1;1;8",
        "2;3;1;2;5"
    })
    void test(
        int _low,
        int _high,
        int _zero,
        int _one,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem2466.countGoodStrings(_low, _high, _zero, _one));
    }

}
