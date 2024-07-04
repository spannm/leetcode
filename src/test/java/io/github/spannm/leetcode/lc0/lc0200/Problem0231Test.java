package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0231Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "1; true",
        "16; true",
        "3; false",
        "-16; false"
    })
    void test(
        int _n,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0231().isPowerOfTwo(_n));
    }

}
