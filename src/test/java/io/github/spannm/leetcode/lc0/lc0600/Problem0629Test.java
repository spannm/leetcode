package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0629Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "3; 0; 1",
        "3; 1; 2"
    })
    void test(int _n, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0629().kInversePairs(_n, _k));
    }

}
