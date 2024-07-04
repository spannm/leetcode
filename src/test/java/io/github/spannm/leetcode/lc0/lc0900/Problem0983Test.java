package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0983Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] days {0}, costs {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "8; 1,2,3; 1",
        "1,4,6,7,8,20; 2,7,15; 11",
        "1,2,3,4,5,6,7,8,9,10,30,31; 2,7,15; 17"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _days,
        @ConvertWith(CsvToIntArray.class) int[] _costs,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0983().mincostTickets(_days, _costs));
    }

}
