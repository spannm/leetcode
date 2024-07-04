package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0115Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "rabbbit; rabbit; 3",
        "babgbag; bag; 5"
    })
    void test(String _s, String _t, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0115().numDistinct(_s, _t));
    }

}
