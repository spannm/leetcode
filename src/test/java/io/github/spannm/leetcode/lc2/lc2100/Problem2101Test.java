package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2101Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[2,1,3],[6,1,4]; 2",
        "[1,1,5],[10,10,5]; 1",
        "[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]; 5"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _bombs,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2101().maximumDetonation(_bombs));
    }

}
