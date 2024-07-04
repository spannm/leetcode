package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0064Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,3,1],[1,5,1],[4,2,1]; 7",
        "[1,2,3],[4,5,6]; 12"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _grid,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0064().minPathSum(_grid));
    }

}
