package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1903Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "52; 5",
        "4206; ''",
        "35427; 35427"
    })
    void test(String _num, String _expectedResult) {
        assertEquals(_expectedResult, new Problem1903().largestOddNumber(_num));
    }

}
