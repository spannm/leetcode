package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1704Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "book; true",
        "textbook; false"
    })
    void test(
        String _str,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem1704().halvesAreAlike(_str));
    }

}
