package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2390Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "leet**cod*e;lecoe",
        "erase*****;''",
        "ABCerase*****DEF;ABCDEF",
        "abcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxz"
        + "*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*"
        + "z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*z*; abcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijk"
        + "lmnopqrstuvwxabcdefghijklmnopqrstuvwx"
    })
    void test(
        String _str,
        String _expectedResult) {

        assertEquals(_expectedResult, new Problem2390().removeStars(_str));
    }

}
