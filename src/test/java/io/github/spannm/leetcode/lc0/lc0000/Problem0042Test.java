package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0042Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "0,1,0,2,1,0,1,3,2,1,2,1; 6",
        "4,2,0,3,2,5; 9"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _heights,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0042().trap(_heights));
    }

}
