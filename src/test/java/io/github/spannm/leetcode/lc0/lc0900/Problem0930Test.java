package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0930Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,0,1,0,1; 2; 4",
        "0,0,0,0,0; 0; 15"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _goal, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0930().numSubarraysWithSum(_nums, _goal));
    }

}
