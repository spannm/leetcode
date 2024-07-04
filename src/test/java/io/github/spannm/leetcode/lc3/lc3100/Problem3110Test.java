package io.github.spannm.leetcode.lc3.lc3100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem3110Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "hello; 13",
        "zaz; 50"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem3110().scoreOfString(_s));
    }

}
