package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1402Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "-1,-8,0,5,-9; 14",
        "4,3,2; 20",
        "-1,-4,-5; 0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _satisfaction,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem1402.maxSatisfaction(_satisfaction));
    }

}
