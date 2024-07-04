package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0121Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "7,1,5,3,6,4; 5",
        "7,6,4,3,1; 0",
        "1,4,2; 3",
        "1,2; 1",
        "1,1; 0",
        "1; 0"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _prices, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0121().maxProfit(_prices));
    }

}
