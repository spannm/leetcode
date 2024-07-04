package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0378Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[1,5,9],[10,11,13],[12,13,15]; 8; 13",
        "[-5]; 1; -5"
    })
    void test(@ConvertWith(CsvToIntMatrix.class) int[][] _matrix, int _k,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0378().kthSmallest(_matrix, _k));
    }

}
