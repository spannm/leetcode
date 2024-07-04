package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0473Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,1,2,2,2; true",
        "3,3,3,3,4; false"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0473().makesquare(_nums));
    }

}
