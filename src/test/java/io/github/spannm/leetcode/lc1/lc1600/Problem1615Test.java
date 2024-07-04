package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1615Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4; [0,1],[0,3],[1,2],[1,3]; 4",
        "5; [0,1],[0,3],[1,2],[1,3],[2,3],[2,4]; 5",
        "8; [0,1],[1,2],[2,3],[2,4],[5,6],[5,7]; 5"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _roads,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1615().maximalNetworkRank(_n, _roads));
    }

}
