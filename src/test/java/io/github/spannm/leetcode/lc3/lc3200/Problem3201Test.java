package io.github.spannm.leetcode.lc3.lc3200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem3201Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4; 4",
        "1,2,1,1,2,1,2; 6",
        "1,3; 2"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _expectedResult) {
        assertEquals(_expectedResult, new Problem3201().maximumLength(_nums));
    }
}
