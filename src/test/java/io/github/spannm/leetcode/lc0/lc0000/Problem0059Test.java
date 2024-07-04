package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0059Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "3; [1,2,3],[8,9,4],[7,6,5]",
        "1; [1]"
    })
    void test(
        int _size,
        @ConvertWith(CsvToIntMatrix.class) int[][] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem0059().generateMatrix(_size));
    }

}
