package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0714Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, fee {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3,2,8,4,9; 2; 8",
        "1,3,7,5,10,3; 3; 6"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _prices,
        int _fee,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0714().maxProfit(_prices, _fee));
    }

}
