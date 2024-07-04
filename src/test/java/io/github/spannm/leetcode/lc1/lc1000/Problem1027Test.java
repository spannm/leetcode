package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1027Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3,6,9,12; 4",
        "9,4,7,2,10; 3",
        "20,1,15,3,10,5,8; 4"
    })

    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1027().longestArithSeqLength(_nums));
    }

}
