package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1799Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2; 1",
        "3,4,6,8; 11",
        "1,2,3,4,5,6; 14"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1799().maxScore(_nums));
    }

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1; 2; 1",
        "4; 8; 4",
        "8; 4; 4"
    })
    void testGcd(
        int _a,
        int _b,
        int _expectedResult) {
        assertEquals(_expectedResult, Problem1799.gcd(_a, _b));
    }

}
