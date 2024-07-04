package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0084Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,1,5,6,2,3; 10",
        "2,4; 4"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _heights,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0084().largestRectangleArea(_heights));
    }

}
