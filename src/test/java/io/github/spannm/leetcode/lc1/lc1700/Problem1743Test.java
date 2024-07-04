package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1743Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "[2,1],[3,4],[3,2]; 1,2,3,4",
        "[4,-2],[1,4],[-3,1]; -2,4,1,-3",
        "[100000,-100000]; [100000,-100000]"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _adjacentPairs,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem1743().restoreArray(_adjacentPairs));
    }

}
