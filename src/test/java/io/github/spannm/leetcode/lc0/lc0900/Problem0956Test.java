package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0956Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,6; 6",
        "1,2,3,4,5,6; 10",
        "1,2; 0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _rods,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0956().tallestBillboard(_rods));
    }

}
