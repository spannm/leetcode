package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem2215Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], nbCoins={1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 2,4,6; [1,3],[4,6]",
        "1,2,3,3; 1,1,2,2; [3],[]"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums1,
        @ConvertWith(CsvToIntArray.class) int[] _nums2,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {

        assertEquals(_expectedResult, new Problem2215().findDifference(_nums1, _nums2));
    }

}
