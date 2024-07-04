package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1351Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]; 8",
        "[3,2],[1,0]; 0"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _grid,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem1351.countNegatives(_grid));
    }

}
