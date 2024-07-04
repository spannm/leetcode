package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0054Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,2,3],[4,5,6],[7,8,9]; 1,2,3,6,9,8,7,4,5",
        "[1,2,3,4],[5,6,7,8],[9,10,11,12]; 1,2,3,4,8,12,11,10,9,5,6,7"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _matrix,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {

        assertEquals(_expectedResult, Problem0054.spiralOrder(_matrix));
    }

}
