package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0566Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "[1,2],[3,4]; 1; 4; [1,2,3,4]",
        "[1,2],[3,4]; 2; 4; [1,2],[3,4]",
        "[1,2]; 1; 1; [1,2]"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _mat,
        int _r,
        int _c,
        @ConvertWith(CsvToIntMatrix.class) int[][] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0566().matrixReshape(_mat, _r, _c));
    }

}
