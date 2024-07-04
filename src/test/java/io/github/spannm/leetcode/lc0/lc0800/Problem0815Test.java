package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0815Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1}, {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "[1,2,7],[3,6,7]; 1; 6; 2",
        "[7,12],[4,5,15],[6],[15,19],[9,12,13]; 15; 12; -1"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _routes,
        int _source,
        int _target,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0815().numBusesToDestination(_routes, _source, _target));
    }

}
