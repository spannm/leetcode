package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0135Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,0,2; 5",
        "1,2,2; 4"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _ratings,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0135().candy(_ratings));
    }

}
