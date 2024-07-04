package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2147Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "SSPPSPS; 3",
        "PPSPSP; 1",
        "S; 0"
    })
    void test(
        String _corridor,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2147().numberOfWays(_corridor));
    }

}
