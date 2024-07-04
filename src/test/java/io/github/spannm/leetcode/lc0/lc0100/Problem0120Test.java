package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0120Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[2],[3,4],[6,5,7],[4,1,8,3]; 11",
        "[-10]; -10",
        "; 0",
        "[-1],[2,3],[1,-1,-3]; -1"
    })
    void test(
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _triangle,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0120().minimumTotal(_triangle));

    }

}
