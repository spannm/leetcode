package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0273Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "0; Zero",
        "9; Nine",
        "10; Ten",
        "123; One Hundred Twenty Three",
        "12345; Twelve Thousand Three Hundred Forty Five",
        "1234567; One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    })
    void test(
        int _num,
        String _expectedResult) {
        assertEquals(_expectedResult, new Problem0273().numberToWords(_num));
    }

}
