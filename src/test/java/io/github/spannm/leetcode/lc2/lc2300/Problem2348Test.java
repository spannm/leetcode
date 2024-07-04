package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2348Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,3,0,0,2,0,0,4; 6",
        "0,0,0,2,0,0; 9",
        "2,10,2019; 0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        long _expectedResult) {

        assertEquals(_expectedResult, new Problem2348().zeroFilledSubarray(_nums));
    }

}
