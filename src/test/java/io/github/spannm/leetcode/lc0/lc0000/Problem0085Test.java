package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0085Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]; 6",
        "[0]; 0",
        "[1]; 1"
    })
    void test(@ConvertWith(CsvToCharMatrix.class) char[][] _matrix,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0085().maximalRectangle(_matrix));
    }

}
