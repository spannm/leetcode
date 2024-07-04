package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0209Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}] => {2}")
    @CsvSource(delimiter = ';', value = {
        "7; 2,3,1,2,4,3; 2",
        "4; 1,4,4; 1",
        "11; 1,1,1,1,1,1,1,1; 0"
    })
    void test(
        int _target,
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem0209.minSubArrayLen(_target, _nums));
    }

}
