package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem2092Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "6; [1,2,5],[2,3,8],[1,5,10]; 1; 0,1,2,3,5",
        "4; [3,1,3],[1,2,2],[0,3,3]; 3; 0,1,3",
        "5; [3,4,2],[1,2,1],[2,3,1]; 1; 0,1,2,3,4"
    })
    void test(int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _meetings,
        int _first,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {
        assertEquals(_expectedResult, new Problem2092().findAllPeople(_n, _meetings, _first));
    }

}
