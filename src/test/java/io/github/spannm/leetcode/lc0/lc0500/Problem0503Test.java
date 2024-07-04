package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0503Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,1; 2,-1,2",
        "1,2,3,4,3; 2,3,4,-1,4"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0503().nextGreaterElements(_nums));
    }

}
