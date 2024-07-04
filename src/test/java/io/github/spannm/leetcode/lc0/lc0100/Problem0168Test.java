package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0168Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1; A",
        "2; B",
        "26; Z",
        "27; AA",
        "28; AB",
        "701; ZY",
        "702; ZZ",
        "703; AAA"
    })

    void test(
        int _columnNumber,
        String _expectedResult) {
        assertEquals(_expectedResult, new Problem0168().convertToTitle(_columnNumber));
    }

}
