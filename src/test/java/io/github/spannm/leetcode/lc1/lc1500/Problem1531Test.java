package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1531Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "aaabcccd; 2; 4",
        "aabbaa; 2; 2",
        "aaaaaaaaaaa; 0; 3",
        "''; 3; 0",
        "a; 2; 0"
    })
    void test(String _s, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1531().getLengthOfOptimalCompression(_s, _k));
    }

}
