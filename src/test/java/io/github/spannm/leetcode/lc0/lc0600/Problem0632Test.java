package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0632Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[4,10,15,24,26],[0,9,12,20],[5,18,22,30]; 20,24",
        "[1,2,3],[1,2,3],[1,2,3]; 1,1"
    })
    void test(
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _nums,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0632().smallestRange(_nums));
    }

}
