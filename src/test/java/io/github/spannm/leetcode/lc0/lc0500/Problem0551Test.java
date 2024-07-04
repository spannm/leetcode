package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0551Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "PPALLP; true",
        "PPALLL; false"
    })
    void test(String _s, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0551().checkRecord(_s));
    }

}
