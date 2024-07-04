package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0788Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "10; 4",
        "1; 0",
        "2; 1"
    })
    void test(int _n, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0788().rotatedDigits(_n));
    }

}
