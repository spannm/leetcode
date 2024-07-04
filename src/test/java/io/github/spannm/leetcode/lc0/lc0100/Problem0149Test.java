package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0149Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,1],[2,2],[3,3]; 3",
        "[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]; 4"
    })
    void test(@ConvertWith(CsvToIntMatrix.class) int[][] _points,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0149().maxPoints(_points));
    }

}
