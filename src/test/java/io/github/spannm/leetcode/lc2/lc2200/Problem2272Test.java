package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2272Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "aababbb; 3",
        "abcde; 0"
    })
    void test(
        String _s,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem2272().largestVariance(_s));
    }

}
