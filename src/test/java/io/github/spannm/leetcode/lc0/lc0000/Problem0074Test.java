package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0074Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[1,3,5,7],[10,11,16,20],[23,30,34,60]; 3; true",
        "[1,3,5,7],[10,11,16,20],[23,30,34,60]; 13; false"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _matrix,
        int _target,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0074().searchMatrix(_matrix, _target));
    }

}
