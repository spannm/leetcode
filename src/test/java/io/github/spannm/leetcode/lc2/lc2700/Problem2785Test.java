package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2785Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "lEetcOde; lEOtcede",
        "lYmpH; lYmpH",
        ";",
        "aeiou;aeiou",
        "AEIOU;AEIOU"
    })
    void test(
        String _s,
        String _expectedResult) {

        assertEquals(_expectedResult, new Problem2785().sortVowels(_s));
    }

}
