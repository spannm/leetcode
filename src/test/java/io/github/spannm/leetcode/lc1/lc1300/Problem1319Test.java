package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1319Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, connections {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4; [0,1],[0,2],[1,2]; 1",
        "6; [0,1],[0,2],[0,3],[1,2],[1,3]; 2"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _connections,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1319().makeConnected(_n, _connections));
    }

}
