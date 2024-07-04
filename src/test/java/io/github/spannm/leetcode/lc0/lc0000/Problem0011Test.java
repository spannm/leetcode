package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0011Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,8,6,2,5,4,8,3,7 ;49",
        "1,1; 1",
        "src/test/resources/lc0/lc0000/Problem0011Test_1.csv; 402471897"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _input,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0011().maxArea(_input));
    }

}
