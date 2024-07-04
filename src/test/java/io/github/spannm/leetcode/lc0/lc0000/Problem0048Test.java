package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0048Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,2,3],[4,5,6],[7,8,9]; [7,4,1],[8,5,2],[9,6,3]",
        "[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]; [15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _matrix,
        @ConvertWith(CsvToIntMatrix.class) int[][] _expectedResult) {
        new Problem0048().rotate(_matrix);
        assertArrayEquals(_expectedResult, _matrix);
    }
}
