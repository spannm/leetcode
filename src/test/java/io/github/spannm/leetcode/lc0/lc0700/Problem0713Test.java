package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0713Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "10,5,2,6; 100; 8",
        "1,2,3; 0; 0"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0713().numSubarrayProductLessThanK(_nums, _k));
    }

}
