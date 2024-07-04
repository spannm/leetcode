package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0198Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,1; 4",
        "2,7,9,3,1; 12",
        "2,1,1,2; 4"
    })

    void test(
        @ConvertWith(CsvToIntArray.class) int[] _money,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0198().rob(_money));
    }

}
