package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0001Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, target {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2,7,11,15; 9; 0,1",
        "3,2,4; 6; 1,2",
        "3,3; 6; 0,1",
        "3,2,3; 6; 0,2",
        "0,4,3,0; 0; 0,3",
        "-3,4,3,90; 0; 0,2"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _input,
        int _target,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem0001().twoSum(_input, _target));
    }

}
