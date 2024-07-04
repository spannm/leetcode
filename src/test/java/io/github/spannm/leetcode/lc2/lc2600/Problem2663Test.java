package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2663Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "abcz; 26; abda",
        "dc; 4; ''"
    })
    void test(
        String _s,
        int _k,
        String _expectedResult) {
        assertEquals(_expectedResult, new Problem2663().smallestBeautifulString(_s, _k));
    }

}
