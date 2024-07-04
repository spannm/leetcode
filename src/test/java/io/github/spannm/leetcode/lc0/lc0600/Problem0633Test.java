package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0633Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "5; true",
        "3; false",
        "2147483600; true"
    })
    void test(int _c, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0633().judgeSquareSum(_c));
    }

}
