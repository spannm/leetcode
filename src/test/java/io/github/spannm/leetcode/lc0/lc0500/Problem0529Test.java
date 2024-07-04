package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0529Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[E,E,E,E,E],[E,E,M,E,E],[E,E,E,E,E],[E,E,E,E,E]; 3,0; [B,1,E,1,B],[B,1,M,1,B],[B,1,1,1,B],[B,B,B,B,B]",
        "[B,1,E,1,B],[B,1,M,1,B],[B,1,1,1,B],[B,B,B,B,B]; 1,2; [B,1,E,1,B],[B,1,X,1,B],[B,1,1,1,B],[B,B,B,B,B]"
    })
    void test(
        @ConvertWith(CsvToCharMatrix.class) char[][] _board,
        @ConvertWith(CsvToIntArray.class) int[] _click,
        @ConvertWith(CsvToCharMatrix.class) char[][] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0529().updateBoard(_board, _click));
    }

}
