package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0392Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "abc; ahbgdc; true",
        "axc; ahbgdc; false",
        "''; ahbgdc; true",
        "b; abc; true",
        "aaaaaa; bbaaaa; false"
    })
    void test(
        String _sub,
        String _str,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0392().isSubsequence(_sub, _str));
    }

}
