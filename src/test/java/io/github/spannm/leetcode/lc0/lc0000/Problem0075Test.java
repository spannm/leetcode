package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0075Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,0,2,1,1,0; 0,0,1,1,2,2",
        "2,0,1; 0,1,2"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem0075().sortColors(_nums));
    }
}
