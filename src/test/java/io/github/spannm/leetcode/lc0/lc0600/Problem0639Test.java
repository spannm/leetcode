package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0639Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "*; 9",
        "1*; 18",
        "2*; 15",
        "7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*; 196465252"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0639().numDecodings(_s));
    }

}
