package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0685Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,2],[1,3],[2,3]; [2,3]",
        "[1,2],[2,3],[3,4],[4,1],[1,5]; [4,1]"
    })
    void test(@ConvertWith(CsvToIntMatrix.class) int[][] _edges, @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0685().findRedundantDirectedConnection(_edges));
    }

}
