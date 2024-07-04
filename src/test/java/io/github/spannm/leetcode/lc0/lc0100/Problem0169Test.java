package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0169Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3,2,3; 3",
        "2,2,1,1,1,2,2; 2"
    })

    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0169().majorityElement(_nums));
    }

}
