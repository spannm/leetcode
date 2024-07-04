package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0739Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "73,74,75,71,69,72,76,73; 1,1,4,2,1,1,0,0",
        "30,40,50,60; 1,1,1,0",
        "30,60,90; 1,1,0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _temps,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0739().dailyTemperatures(_temps));
    }

}
