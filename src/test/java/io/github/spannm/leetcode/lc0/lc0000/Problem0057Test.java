package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

@Disabled
class Problem0057Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, new {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[[1,3],[6,9]]; [2,5]; [[1,5],[6,9]]",
        "[[1,2],[3,5],[6,7],[8,10],[12,16]]; [4,8]; [[1,2],[3,10],[12,16]]",
        "[]; [5,7]; [[5,7]]",
        "[[1,5]]; [2,7]; [[1,7]]",
        "[[1,5]]; [0,3]; [[0,5]]",
        "[[1,5],[6,8]]; [5,6]; [[1,8]]",
        "[[2,4],[5,7],[8,10],[11,13]]; [3,6]; [[2,7],[8,10],[11,13]]",
        "[[3,5],[12,15]]; [6,6]; [[3,5],[6,6],[12,15]]"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _intervals,
        @ConvertWith(CsvToIntArray.class) int[] _newInterval,
        @ConvertWith(CsvToIntMatrix.class) int[][] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem0057().insert(_intervals, _newInterval));
    }

}
