package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0190Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "00000010100101000001111010011100; 00111001011110000010100101000000",
        "11111111111111111111111111111101; 10111111111111111111111111111111"
    })

    void test(
        String _n,
        String _expectedResult) {

        int n = (int) Long.parseLong(_n, 2);
        int expectedResult = (int) Long.parseLong(_expectedResult, 2);

        assertEquals(expectedResult, new Problem0190().reverseBits(n));
    }

}
