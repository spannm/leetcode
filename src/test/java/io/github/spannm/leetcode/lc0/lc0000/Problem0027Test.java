package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0027Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "3,2,2,3; 3; 2",
        "0,1,2,2,3,0,4,2; 2; 5"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _val,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0027().removeElement(_nums, _val));
    }

}
