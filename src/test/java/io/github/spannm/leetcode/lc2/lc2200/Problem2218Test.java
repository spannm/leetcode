package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem2218Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], nbCoins={1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[1,100,3],[7,8,9]; 2; 101",
        "[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]; 7; 706"
    })
    void test(
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _piles,
        int _nbCoins,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2218().maxValueOfCoins(_piles, _nbCoins));
    }

}
