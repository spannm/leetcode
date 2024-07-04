package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1716Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4; 10",
        "10; 37",
        "20; 96"
    })
    void test(int _n, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1716().totalMoney(_n));
    }

}
