package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2742Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,2; 1,2,3,2; 3",
        "2,3,4,2; 1,1,1,1; 4"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _cost,
        @ConvertWith(CsvToIntArray.class) int[] _time,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem2742.paintWalls(_cost, _time));
    }

}
