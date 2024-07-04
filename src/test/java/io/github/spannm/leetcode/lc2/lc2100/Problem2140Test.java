package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2140Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] questions=[{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[3,2],[4,3],[4,4],[2,5]; 5",
        "[1,1],[2,2],[3,3],[4,4],[5,5]; 7",
        "[21,5],[92,3],[74,2],[39,4],[58,2],[5,5],[49,4],[65,3]; 157"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _questions,
        long _expectedResult) {
        assertEquals(_expectedResult, new Problem2140().mostPoints(_questions));
    }

}
