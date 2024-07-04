package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1456Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, substr len {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "abciiidef; 3; 3",
        "aeiou; 2; 2",
        "leetcode; 3; 2",
        "ibpbhixfiouhdljnjfflpapptrxgcomvnb; 33; 7"
    })
    void test(
        String _str,
        int _len,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1456().maxVowels(_str, _len));
    }

}
