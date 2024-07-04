package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0647Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "''; 0",
        "a; 1",
        "abc; 3",
        "aaa; 6"
    })
    void test(String _s, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0647().countSubstrings(_s));
    }

}
