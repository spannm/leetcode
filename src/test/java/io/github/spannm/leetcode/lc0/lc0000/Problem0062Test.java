package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0062Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "3;7;28",
        "3;2;3"
    })
    void test(
        int _m,
        int _n,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0062().uniquePaths(_m, _n));
    }

}
