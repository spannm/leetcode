package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0039Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2,3,6,7; 7; [2,2,3],[7]",
        "2,3,5; 8; [2,2,2,2],[2,3,3],[3,5]",
        "2; 1; "
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _candidates,
        int _target,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {

        assertEquals(_expectedResult, new Problem0039().combinationSum(_candidates, _target));
    }
}
