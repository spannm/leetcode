package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1122Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2,3,1,3,2,4,6,7,9,2,19; 2,1,4,3,9,6; 2,2,2,1,4,3,3,9,6,7,19",
        "28,6,22,8,44,17; 22,28,8,6; 22,28,8,6,17,44"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _arr1,
        @ConvertWith(CsvToIntArray.class) int[] _arr2,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem1122().relativeSortArray(_arr1, _arr2));
    }
}
