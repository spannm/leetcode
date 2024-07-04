package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0018Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,0,-1,0,-2,2; 0; [-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]",
        "2,2,2,2,2; 8; [2,2,2,2]",
        "1000000000,1000000000,1000000000,1000000000; -294967296; ",
        "-1000000000,-1000000000,1000000000,-1000000000,-1000000000; 294967296; "
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _target,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {

        assertEquals(_expectedResult, new Problem0018().fourSum(_nums, _target));
    }

}
