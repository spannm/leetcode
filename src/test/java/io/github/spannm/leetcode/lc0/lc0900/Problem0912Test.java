package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0912Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "100,9; 9,100",
        "5,2,3,1; 1,2,3,5",
        "5,1,1,2,0,0; 0,0,1,1,2,5",
        "50000,-50000,0,-10,10; -50000,-10,0,10,50000",
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _input,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem0912().sortArray(_input));
    }

}
