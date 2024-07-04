package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0347Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "1,1,1,2,2,3; 2; 1,2",
        "1; 1; 1",
        "1,1,1,2,2,2,3,3,4,5,5,5,5; 3; 5,1,2"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _k,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, Problem0347.topKFrequent(_nums, _k));
    }

}
