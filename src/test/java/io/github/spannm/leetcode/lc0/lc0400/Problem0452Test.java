package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0452Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[10,16],[2,8],[1,6],[7,12]; 2",
        "[1,2],[3,4],[5,6],[7,8]; 4",
        "[1,2],[2,3],[3,4],[4,5]; 2",
        "[1,2147483647]; 1",
        "[-2147483646,-2147483645],[2147483646,2147483647]; 2"
    })
    void test(@ConvertWith(CsvToIntMatrix.class) int[][] _input, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0452().findMinArrowShots(_input));
    }

}
