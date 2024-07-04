package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0306Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "112358; true",
        "199100199; true"
    })
    void test(String _num, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0306().isAdditiveNumber(_num));
    }
}
