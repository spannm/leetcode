package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0088Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1}; {2}; {3} --> {4}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,0,0,0; 3; 2,5,6; 3; 1,2,2,3,5,6",
        "1; 1; ; 0; 1",
        "0; 0; 1; 1; 1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums1,
        int _m,
        @ConvertWith(CsvToIntArray.class) int[] _nums2,
        int _n,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        new Problem0088().merge(_nums1, _m, _nums2, _n);
        assertArrayEquals(_expectedResult, _nums1);
    }
}
