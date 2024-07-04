package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1992Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,0,0],[0,1,1],[0,1,1]; [0,0,0,0],[1,1,2,2]",
        "[1,1],[1,1]; [0,0,1,1]",
        "[0]; "
    })
    void test(@ConvertWith(CsvToIntMatrix.class) int[][] _land,
        @ConvertWith(CsvToIntMatrix.class) int[][] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem1992().findFarmland(_land));
    }

}
