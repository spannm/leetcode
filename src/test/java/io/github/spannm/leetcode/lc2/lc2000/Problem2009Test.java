package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2009Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4,2,5,3; 0",
        "1,2,3,5,6; 1",
        "1,10,100,1000; 3",
        "1,2,3,5,4; 0",
        "1,1,1,1; 0",
        "6,10,1,8,3,4,7,9,5,2; 0",
        "6,10,1,8,3,4,7,5,2; 1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2009().minOperations(_nums));
    }

}
