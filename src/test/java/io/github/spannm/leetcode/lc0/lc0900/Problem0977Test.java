package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0977Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "-4,-1,0,3,10; 0,1,9,16,100",
        "-7,-3,2,3,11; 4,9,9,49,121"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0977().sortedSquares(_nums));
    }

}
