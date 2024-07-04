package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0201Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5;7;4",
        "0;0;0",
        "1;2147483647;0"
    })
    void test(int _left, int _right, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0201().rangeBitwiseAnd(_left, _right));
    }

}
