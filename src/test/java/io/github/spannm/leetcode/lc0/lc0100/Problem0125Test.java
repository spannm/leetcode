package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0125Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "A man, a plan, a canal: Panama; true",
        "race a car; false",
        "''; true"
    })
    void test(String _s, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0125().isPalindrome(_s));
    }

}
