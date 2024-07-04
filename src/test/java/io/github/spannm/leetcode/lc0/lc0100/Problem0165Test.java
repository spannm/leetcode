package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0165Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1.01; 1.001; 0",
        "1.0; 1.0.0; 0",
        "2.0.0; 2.0.0; 0",
        "0.1; 1.1; -1"
    })
    void test(
        String _version1,
        String _version2,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0165().compareVersion(_version1, _version2));
    }

}
