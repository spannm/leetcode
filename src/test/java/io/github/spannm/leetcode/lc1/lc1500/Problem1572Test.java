package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1572Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,2,3],[4,5,6],[7,8,9]; 25",
        "[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]; 8",
        "[5]; 5"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _matrix,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem1572.diagonalSum(_matrix));
    }

}
