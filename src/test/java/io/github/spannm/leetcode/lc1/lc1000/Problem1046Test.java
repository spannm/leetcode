package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1046Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,7,4,1,8,1; 1",
        "1; 1",
        "7,6,7,6,9; 3"
    })

    void test(
        @ConvertWith(CsvToIntArray.class) int[] _weigths,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1046().lastStoneWeight(_weigths));
    }

}
