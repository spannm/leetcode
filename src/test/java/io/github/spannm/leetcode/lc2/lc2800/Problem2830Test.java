package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem2830Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5; [0,0,1],[0,2,2],[1,3,2]; 3",
        "5; [0,0,1],[0,2,10],[1,3,2]; 10"
    })
    void test(
        int _n,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _offers,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2830().maximizeTheProfit(_n, _offers));
    }

}
