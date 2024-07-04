package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1091Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[0,1],[1,0]; 2",
        "[0,0,0],[1,1,0],[1,1,0]; 4",
        "[1,0,0],[1,1,0],[1,1,0]; -1"
    })

    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _grid,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1091().shortestPathBinaryMatrix(_grid));
    }

}
