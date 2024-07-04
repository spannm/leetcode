package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1547Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "7; 1,3,4,5; 16",
        "9; 5,6,1,4,2; 22"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntArray.class) int[] _cuts,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem1547.minCost(_n, _cuts));
    }

}
