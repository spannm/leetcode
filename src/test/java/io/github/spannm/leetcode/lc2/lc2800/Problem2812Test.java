package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem2812Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,0,0],[0,0,0],[0,0,1]; 0",
        "[0,0,1],[0,0,0],[0,0,0]; 2",
        "[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]; 2"
    })
    void test(@ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _grid, int _expectedResult) {
        assertEquals(_expectedResult, new Problem2812().maximumSafenessFactor(_grid));
    }
}
