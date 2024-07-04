package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem2192Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "8; [0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]; [],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]",
        "5; [0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]; [],[0],[0,1],[0,1,2],[0,1,2,3]"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _edges,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {
        assertEquals(_expectedResult, new Problem2192().getAncestors(_n, _edges));
    }
}
