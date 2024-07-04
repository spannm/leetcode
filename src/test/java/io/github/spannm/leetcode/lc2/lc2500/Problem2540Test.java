package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2540Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 2,4; 2",
        "1,2,3,6; 2,3,4,5; 2"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums1, @ConvertWith(CsvToIntArray.class) int[] _nums2, int _expectedResult) {
        assertEquals(_expectedResult, new Problem2540().getCommon(_nums1, _nums2));
    }

}
