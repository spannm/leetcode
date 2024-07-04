package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0010Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "aa; a; false",
        "aa; a*; true",
        "ab; .*; true"
    })
    void test(String _str, String _pattern, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0010().isMatch(_str, _pattern));
    }

}
