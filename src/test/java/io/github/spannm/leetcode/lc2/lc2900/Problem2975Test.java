package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2975Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2}; {3} --> {4}")
    @CsvSource(delimiter = ';', value = {
        "4; 3; 2,3; 2; 4",
        "6; 7; 2; 4; -1"
    })
    void test(
        int _m,
        int _n,
        @ConvertWith(CsvToIntArray.class) int[] _hFences,
        @ConvertWith(CsvToIntArray.class) int[] _vFences,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2975().maximizeSquareArea(_m, _n, _hFences, _vFences));
    }

}
