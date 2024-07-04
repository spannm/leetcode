package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1424Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "[1,2,3],[4,5,6],[7,8,9]; 1,4,2,7,5,3,8,6,9",
        "[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]; 1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16",
        "[1,2,3,4,5,6]; 1,2,3,4,5,6"
    })
    void test(
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _nums,
        @ConvertWith(CsvToIntArray.class) int[] _expected) {

        assertArrayEquals(_expected, new Problem1424().findDiagonalOrder(_nums));
    }

}
