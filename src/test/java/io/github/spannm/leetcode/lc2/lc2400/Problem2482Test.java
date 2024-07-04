package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2482Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[0,1,1],[1,0,1],[0,0,1]; [0,0,4],[0,0,4],[-2,-2,2]",
        "[1,1,1],[1,1,1]; [5,5,5],[5,5,5]"
    })

    void test(
        @ConvertWith(LeetcodeBaseTest.CsvToIntMatrix.class) int[][] _grid,
        @ConvertWith(LeetcodeBaseTest.CsvToIntMatrix.class) int[][] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem2482().onesMinusZeros(_grid));
    }
}
