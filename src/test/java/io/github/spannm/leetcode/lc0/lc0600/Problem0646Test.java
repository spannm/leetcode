package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0646Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,2],[2,3],[3,4]; 2",
        "[1,2],[7,8],[4,5]; 3"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _pairs,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0646().findLongestChain(_pairs));
    }

}
