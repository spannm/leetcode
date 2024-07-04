package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0859Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "ab; ba; true",
        "ab; ab; false",
        "aa; aa; true"
    })
    void test(
        String _s,
        String _goal,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0859().buddyStrings(_s, _goal));
    }

}
