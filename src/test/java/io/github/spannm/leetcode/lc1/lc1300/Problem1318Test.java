package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1318Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "2; 6; 5; 3",
        "4; 2; 7; 1",
        "1; 2; 3; 0"
    })
    void test(
        int _a,
        int _b,
        int _c,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1318().minFlips(_a, _b, _c));
    }

}
