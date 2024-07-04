package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0931Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[2,1,3],[6,5,4],[7,8,9]; 13",
        "[-19,57],[-40,-5]; -59"
    })
    void test(@ConvertWith(
        CsvToIntMatrix.class) int[][] _arr,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0931().minFallingPathSum(_arr));
    }

}
