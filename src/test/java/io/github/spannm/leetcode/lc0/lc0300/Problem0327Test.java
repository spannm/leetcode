package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0327Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "-2,5,-1; -2; 2; 3",
        "0; 0; 0; 1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _lower,
        int _upper,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0327().countRangeSum(_nums, _lower, _upper));
    }

}
