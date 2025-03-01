package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0446Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,4,6,8,10; 7",
        "7,7,7,7,7; 16"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _arr, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0446().numberOfArithmeticSlices(_arr));
    }

}
