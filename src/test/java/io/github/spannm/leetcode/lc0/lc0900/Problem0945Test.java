package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0945Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,2; 1",
        "3,2,1,2,1,7; 6"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0945().minIncrementForUnique(_nums));
    }
}
