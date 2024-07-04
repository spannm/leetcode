package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0050Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2.00000; 10; 1024.00000",
        "2.10000; 3; 9.26100",
        "2.00000; -2; 0.25000"
    })
    void test(
        double _x,
        int _n,
        double _expected) {

        double actual = new Problem0050().myPow(_x, _n);
        assertEquals(_expected, actual, 0.0001);
    }

}
