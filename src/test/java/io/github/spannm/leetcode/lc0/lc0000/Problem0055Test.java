package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0055Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,3,1,1,4; true",
        "3,2,1,0,4; false",
        "1; true",
        "2,0; true",
        "2,5,0,0; true"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0055().canJump(_nums));
    }

}
