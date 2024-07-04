package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0802Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,2],[2,3],[5],[0],[5],[],[]; 2,4,5,6",
        "[1,2,3,4],[1,2],[3,4],[0,4],[]; 4"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _graph,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {

        assertEquals(_expectedResult, Problem0802.eventualSafeNodes(_graph));
    }

}
