package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0506Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "5,4,3,2,1; Gold Medal,Silver Medal,Bronze Medal,4,5",
        "10,3,8,9,4; Gold Medal,5,Bronze Medal,Silver Medal,4",
        "1; Gold Medal"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToStringArray.class) String[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0506().findRelativeRanks(_nums));
    }

}
