package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0791Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "cba; abcd; cbad",
        "bcafg; abcd; bcad",
        "kqep; pekeq; kqeep"
    })
    void test(String _s, String _t, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0791().customSortString(_s, _t));
    }

}
