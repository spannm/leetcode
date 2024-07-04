package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0854Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "ab; ba; 1",
        "abc; bca; 2"
    })
    void test(String _s1, String _s2, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0854().kSimilarity(_s1, _s2));
    }

}
