package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0081Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2,5,6,0,0,1,2; 0; true",
        "2,5,6,0,0,1,2; 3; false"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _target,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0081().search(_nums, _target));
    }

}
