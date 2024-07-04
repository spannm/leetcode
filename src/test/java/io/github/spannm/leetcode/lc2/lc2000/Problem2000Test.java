package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2000Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "abcdefd; d; dcbaefd",
        "xyxzxe; z; zxyxxe",
        "abcd; z; abcd"
    })
    void test(String _word, char _ch, String _expectedResult) {
        assertEquals(_expectedResult, new Problem2000().reversePrefix(_word, _ch));
    }

}
