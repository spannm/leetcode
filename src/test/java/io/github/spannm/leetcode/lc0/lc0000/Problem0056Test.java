package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0056Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,3],[2,6],[8,10],[15,18]; [1,6],[8,10],[15,18]",
        "[1,4],[4,5]; [1,5]"
    })
    void test(@ConvertWith(CsvToIntMatrix.class) int[][] _intervals,
        @ConvertWith(CsvToIntMatrix.class) int[][] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0056().merge(_intervals));
    }

}
