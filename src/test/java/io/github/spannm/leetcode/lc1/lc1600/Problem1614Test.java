package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1614Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "(1+(2*3)+((8)/4))+1; 3",
        "(1)+((2))+(((3))); 3"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1614().maxDepth(_s));
    }

}
