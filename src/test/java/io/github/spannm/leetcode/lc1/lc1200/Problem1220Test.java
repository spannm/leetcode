package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1220Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1; 5",
        "2; 10",
        "5; 68"
    })
    void test(
        int _n,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1220().countVowelPermutation(_n));
    }

}
