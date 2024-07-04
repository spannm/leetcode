package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1732Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "-5,1,5,0,-7; 1",
        "-4,-3,-2,-1,4,3,2; 0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _gain,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1732().largestAltitude(_gain));
    }

}
