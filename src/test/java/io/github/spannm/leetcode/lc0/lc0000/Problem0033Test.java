package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0033Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4,5,6,7,0,1,2; 0; 4",
        "4,5,6,7,0,1,2; 3; -1",
        "1; 0; -1"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums,
        int _target,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0033().search(_nums, _target));
    }
}
