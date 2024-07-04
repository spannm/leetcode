package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0661Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,1,1],[1,0,1],[1,1,1]; [0,0,0],[0,0,0],[0,0,0]",
        "[100,200,100],[200,50,200],[100,200,100]; [137,141,137],[141,138,141],[137,141,137]"
    })
    void test(@ConvertWith(CsvToIntMatrix.class) int[][] _img,
        @ConvertWith(CsvToIntMatrix.class) int[][] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0661().imageSmoother(_img));
    }

}
