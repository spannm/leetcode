package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1970Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, [{2}] --> {3}")
    @CsvSource(delimiter = ';', value = {
        "2; 2; [1,1],[2,1],[1,2],[2,2]; 2",
        "2; 2; [1,1],[1,2],[2,1],[2,2]; 1",
        "3; 3; [1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]; 3"
    })
    void test(
        int _rows,
        int _cols,
        @ConvertWith(CsvToIntMatrix.class) int[][] _cells,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1970().latestDayToCross(_rows, _cols, _cells));
    }

}
