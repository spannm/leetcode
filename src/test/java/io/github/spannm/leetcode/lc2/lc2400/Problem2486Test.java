package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2486Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "coaching; coding; 4",
        "abcde; a; 0",
        "z; abcde; 5"
    })
    void test(String _s1, String _s2, int _expectedResult) {
        assertEquals(_expectedResult, new Problem2486().appendCharacters(_s1, _s2));
    }

}
