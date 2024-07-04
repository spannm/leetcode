package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0087Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\", \"{1}\" = {2}")
    @CsvSource(delimiter = ';', value = {
        "great; rgeat; true",
        "abcde; caebd; false",
        "a; a; true",
        "abcdbdacbdac; bdacabcdbdac; true"
    })
    void test(String _s1, String _s2, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0087().isScramble(_s1, _s2));
    }

}
