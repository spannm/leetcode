package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0179Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "10,2; 210",
        "3,30,34,5,9; 9534330",
        "34323,3432; 343234323",
        "0,0,0,0; 0",
        "0,0,0,0,0,0,0,0,0,0,1; 10000000000"
    })

    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        String _expectedResult) {
        assertEquals(_expectedResult, new Problem0179().largestNumber(_nums));
    }

}
