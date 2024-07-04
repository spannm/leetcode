package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0063Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[0,0,0],[0,1,0],[0,0,0]; 2",
        "[0,1],[0,0]; 1"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _obstacleGrid,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0063().uniquePathsWithObstacles(_obstacleGrid));
    }

}
