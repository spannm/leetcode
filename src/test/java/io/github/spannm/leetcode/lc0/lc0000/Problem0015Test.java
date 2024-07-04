package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0015Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "-1,0,1,2,-1,-4; [-1,-1,2], [-1,0,1]",
        "1,1,1; ''",
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {

        assertEquals(_expectedResult, new Problem0015().threeSum(_nums));
    }

}
