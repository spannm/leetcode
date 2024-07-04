package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class Problem1337Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "[1,1,0,0,0],"
      + "[1,1,1,1,0],"
      + "[1,0,0,0,0],"
      + "[1,1,0,0,0],"
      + "[1,1,1,1,1]; 3; 2,0,3",
        "[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]; 2; 0,2"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _matrix,
        int _k,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        int[] result = new Problem1337().kWeakestRows(_matrix, _k);
        assertArrayEquals(_expectedResult, result, "Expected " + Arrays.toString(_expectedResult) + " but was " + Arrays.toString(result));
    }

}
