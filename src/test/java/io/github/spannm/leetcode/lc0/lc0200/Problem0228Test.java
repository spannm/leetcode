package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0228Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "0,1,2,4,5,7; 0->2, 4->5, 7",
        "0,2,3,4,6,8,9; 0, 2->4, 6, 8->9"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToStringList.class) List<String> _expectedResult) {

        assertEquals(_expectedResult, new Problem0228().summaryRanges(_nums));
    }

}
