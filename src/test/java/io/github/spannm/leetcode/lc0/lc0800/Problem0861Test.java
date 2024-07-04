package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0861Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[0,0,1,1],[1,0,1,0],[1,1,0,0]; 39",
        "[0]; 1"
    })
    void test(@ConvertWith(CsvToIntMatrix.class) int[][] _arr, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0861().matrixScore(_arr));
    }

}
