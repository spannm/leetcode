package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1971Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2}; {3} --> {4}")
    @CsvSource(delimiter = ';', value = {
        "3; [0,1],[1,2],[2,0]; 0; 2; true",
        "6; [0,1],[0,2],[3,5],[5,4],[4,3]; 0; 5; false"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _edges,
        int _start, int _end, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem1971().validPath(_n, _edges, _start, _end));
    }

}
