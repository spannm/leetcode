package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1863Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,3; 6",
        "5,1,6; 28",
        "3,4,5,6,7,8; 480"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1863().subsetXORSum(_nums));
    }

}
