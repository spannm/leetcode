package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0040Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "10,1,2,7,6,1,5; 8; [1,1,6],[1,2,5],[1,7],[2,6]",
        "2,5,2,1,2; 5; [1,2,2],[5]"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _candidates,
        int _target,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {
        assertEquals(_expectedResult, new Problem0040().combinationSum2(_candidates, _target));
    }
}
