package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0826Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "2,4,6,8,10; 10,20,30,40,50; 4,5,6,7; 100",
        "85,47,57; 24,66,99; 40,25,25; 0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _difficulty,
        @ConvertWith(CsvToIntArray.class) int[] _profit,
        @ConvertWith(CsvToIntArray.class) int[] _worker,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0826().maxProfitAssignment(_difficulty, _profit, _worker));
    }
}
