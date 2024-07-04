package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0053Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "-2,1,-3,4,-1,2,1,-5,4; 6",
        "1; 1",
        "5,4,-1,7,8; 23"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0053().maxSubArray(_nums));
    }

}
