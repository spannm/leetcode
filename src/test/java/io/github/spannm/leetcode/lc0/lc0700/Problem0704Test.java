package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0704Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] search {1} in [{0}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "-1,0,3,5,9,12; 9; 4"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums,
        int _target,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0704().search(_nums, _target));
    }

}
