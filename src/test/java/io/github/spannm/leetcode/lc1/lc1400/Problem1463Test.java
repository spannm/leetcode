package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1463Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[3,1,1],[2,5,1],[1,5,5],[2,1,1]; 24",
        "[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]; 28"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _grid,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem1463().cherryPickup(_grid));
    }

}
