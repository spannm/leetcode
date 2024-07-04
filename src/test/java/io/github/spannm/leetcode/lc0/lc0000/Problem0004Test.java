package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0004Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] / [{1}] => {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3; 2; 2.00",
        "1,2; 3,4; 2.50000"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums1,
        @ConvertWith(CsvToIntArray.class) int[] _nums2, double _expectedResult) {
        assertEquals(_expectedResult, new Problem0004().findMedianSortedArrays(_nums1, _nums2));
    }

}
