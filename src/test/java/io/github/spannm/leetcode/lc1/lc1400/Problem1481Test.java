package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1481Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5,5,4; 1; 1", "4,3,1,1,3,3,2; 3; 2"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _arr, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1481().findLeastNumOfUniqueInts(_arr, _k));
    }
}
