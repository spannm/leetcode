package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0520Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource({
        "USA,true",
        "FlaG,false",
        "1,true",
        "a,true",
        "B,true",
        "AB,true",
        "ab,true",
        "Ab,true",
        "aB,false"
        })
    void test(String _input, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0520().detectCapitalUse(_input));
    }

}
