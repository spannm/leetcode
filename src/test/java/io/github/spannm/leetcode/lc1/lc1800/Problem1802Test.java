package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1802Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "4;2;6;2",
        "6;1;10;3"
    })
    void test(
        int _n,
        int _index,
        int _maxSum,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1802().maxValue(_n, _index, _maxSum));
    }

}
