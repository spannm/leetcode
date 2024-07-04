package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0310Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4; [1,0],[1,2],[1,3]; 1",
        "6; [3,0],[3,1],[3,2],[3,4],[5,4]; 3,4"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _edges,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {
        assertEquals(_expectedResult, new Problem0310().findMinHeightTrees(_n, _edges));
    }

}
