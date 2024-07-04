package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0065Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "0; true",
        "e; false",
        ".; false",
        "1E9; true"
    })
    void test(String _s, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0065().isNumber(_s));
    }

}
