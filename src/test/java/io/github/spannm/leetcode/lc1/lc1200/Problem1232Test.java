package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1232Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[2,2],[2,0]; true",
        "[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]; true",
        "[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]; false",
        "[0,0],[0,5],[5,5],[5,0]; false",
        "[1,2],[2,3],[3,5]; false"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _coordinates,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem1232().checkStraightLine(_coordinates));
    }

}
