package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0016Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "-1,2,1,-4; 1; 2",
        "0,0,0; 1; 0"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, int _target,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0016().threeSumClosest(_nums, _target));
    }

}
