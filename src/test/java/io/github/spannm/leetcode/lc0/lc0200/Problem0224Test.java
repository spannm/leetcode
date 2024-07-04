package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0224Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "1 + 1; 2",
        "2-1 + 2 ; 3",
        "(1+(4+5+2)-3)+(6+8); 23"
    })
    void test(
        String _s,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0224().calculate(_s));
    }

}
