package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0678Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "(); true",
        "(*); true",
        "(*)); true",
        "(; false",
        "*; true",
        "**; true",
        "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(()); false"
    })
    void test(String _s, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0678().checkValidString(_s));
    }

}
