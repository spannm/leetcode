package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1579Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, target {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4; [3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]; 2",
        "4; [3,1,2],[3,2,3],[1,1,4],[2,1,4]; 0",
        "2; [1,1,2],[2,1,2],[3,1,2]; 2"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _edges,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1579().maxNumEdgesToRemove(_n, _edges));
    }

}
