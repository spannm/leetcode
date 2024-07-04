package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0006Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} on {1} rows --> {2}")
    @CsvSource(delimiter = ';', value = {
        "PAYPALISHIRING; 3; PAHNAPLSIIGYIR",
        "PAYPALISHIRING; 4; PINALSIGYAHRPI",
        "A; 1; A"
    })
    void test(
        String _input, int _numRows, String _expectedResult) {

        assertEquals(_expectedResult, new Problem0006().convert(_input, _numRows));
    }

}
