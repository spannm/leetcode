package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0557Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "Let's take LeetCode contest; s'teL ekat edoCteeL tsetnoc",
        "God Ding; doG gniD",
        "' '; ' '",
        "'  '; '  '",
        "'   '; '   '",
        "' Hi '; ' iH '"
    })
    void test(
        String _str,
        String _expectedResult) {

        assertEquals(_expectedResult, new Problem0557().reverseWords(_str));
    }

}
