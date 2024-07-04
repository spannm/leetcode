package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0628Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 6",
        "1,2,3,4; 24",
        "-1,-2,-3; -6"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0628().maximumProduct(_nums));
    }

}
