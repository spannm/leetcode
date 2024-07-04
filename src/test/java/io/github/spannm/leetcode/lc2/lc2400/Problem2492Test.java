package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2492Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, roads {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4; [1,2,9],[2,3,6],[2,4,5],[1,4,7]; 5",
        "4; [1,2,2],[1,3,4],[3,4,7]; 2"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _roads,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem2492().minScore(_n, _roads));
    }

}
