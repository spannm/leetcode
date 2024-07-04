package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0944Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[2,1,1],[1,1,0],[0,1,1]; 4",
        "[2,1,1],[0,1,1],[1,0,1]; -1",
        "[0,2]; 0",
        "[1],[2],[1],[2]; 1"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _grid,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0944().orangesRotting(_grid));
    }

}
