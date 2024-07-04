package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1637Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[8,7],[9,9],[7,4],[9,7]; 1",
        "[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]; 3"
        })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _points,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem1637().maxWidthOfVerticalArea(_points));
    }
}
