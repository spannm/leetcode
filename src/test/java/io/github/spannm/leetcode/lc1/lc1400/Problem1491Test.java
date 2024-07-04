package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1491Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4000,3000,1000,2000; 2500.0",
        "1000,2000,3000; 2000.0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _salary,
        double _expectedResult) {

        assertEquals(_expectedResult, new Problem1491().average(_salary));
    }

}
