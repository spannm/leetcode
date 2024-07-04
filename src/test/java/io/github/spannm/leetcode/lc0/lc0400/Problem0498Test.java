package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0498Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,2,3],[4,5,6],[7,8,9]; 1,2,4,7,5,3,6,8,9",
        "[1,2],[3,4]; 1,2,3,4"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _matrix,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0498().findDiagonalOrder(_matrix));
    }
}
