package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0007Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "123; 321",
        "-123; -321",
        "120; 21",
        "-2147483648; 0"
    })
    void test(int _intput, int _expected) {
        assertEquals(_expected, new Problem0007().reverse(_intput));
    }

}
