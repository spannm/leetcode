package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1611Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3; 2",
        "6; 4"
    })
    void test(
        int _n,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1611().minimumOneBitOperations(_n));
    }

}
