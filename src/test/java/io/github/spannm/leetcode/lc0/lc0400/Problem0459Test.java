package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0459Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "a; false",
        "aaa; true",
        "abab; true",
        "aba; false",
        "abcabcabcabc; true",
        "abcabcabcabc; true",
        "abcdefghijklmnopqrstuvwxyz; false",
        "abcdefghijklmnopqrstuvwxym; false"
    })
    void test(
        String _input,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0459().repeatedSubstringPattern(_input));
    }

}
