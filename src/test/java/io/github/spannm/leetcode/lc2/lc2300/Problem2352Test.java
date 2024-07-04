package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2352Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[3,2,1],[1,7,6],[2,7,7]; 1",
        "[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]; 3",
        "[3,1,2,2],[1,4,4,4],[2,4,2,2],[2,5,2,2]; 3"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _grid,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem2352.equalPairs(_grid));
    }

}
