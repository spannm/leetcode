package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2090Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "7,4,3,9,1,8,5,2,6; 3; -1,-1,-1,5,4,4,-1,-1,-1",
        "100000; 0; 100000",
        "8; 100000; -1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _k,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem2090().getAverages(_nums, _k));
    }

}
