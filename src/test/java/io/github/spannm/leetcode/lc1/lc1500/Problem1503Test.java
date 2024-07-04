package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1503Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, target {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4; 4,3; 0,1; 4",
        "7; 0,1,2,3,4,5,6,7; ; 7"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntArray.class) int[] _left,
        @ConvertWith(CsvToIntArray.class) int[] _right,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1503().getLastMoment(_n, _left, _right));
    }

}
