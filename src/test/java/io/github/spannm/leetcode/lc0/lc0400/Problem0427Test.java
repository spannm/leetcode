package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0427Test extends LeetcodeBaseTest {

    @Disabled("Cannot set up test data of node")
    @ParameterizedTest(name = "[{index}] [{0}] --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "[0,1],[1,0]; [0,1],[1,0],[1,1],[1,1],[1,0]",
        "[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]; "
        + "[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _grid,
        Object _expectedResult) {
        assertEquals(_expectedResult, new Problem0427().construct(_grid));
    }

}
