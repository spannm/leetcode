package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0058Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "Hello World; 5",
        "   fly me   to   the moon  ; 4",
        "luffy is still joyboy; 6"
    })
    void test(
        String _s,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0058().lengthOfLastWord(_s));
    }

}
