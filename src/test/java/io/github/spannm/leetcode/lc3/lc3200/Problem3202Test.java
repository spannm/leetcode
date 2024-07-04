package io.github.spannm.leetcode.lc3.lc3200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem3202Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5; 2; 5",
        "1,4,2,3,1,4; 3; 4"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem3202().maximumLength(_nums, _k));
    }
}
