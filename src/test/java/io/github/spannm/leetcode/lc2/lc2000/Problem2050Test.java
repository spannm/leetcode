package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2050Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}], [{2}] --> {3}")
    @CsvSource(delimiter = ';', value = {
        "3; [1,3],[2,3]; 3,2,5; 8",
        "5; [1,5],[2,5],[3,5],[3,4],[4,5]; 1,2,3,4,5; 12"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _relations,
        @ConvertWith(CsvToIntArray.class) int[] _time,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2050().minimumTime(_n, _relations, _time));
    }

}
