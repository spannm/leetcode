package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0091Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "12; 2",
        "226; 3",
        "06; 0"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0091().numDecodings(_s));
    }

}
