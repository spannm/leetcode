package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0539Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "23:59,00:00; 1",
        "00:00,23:59,00:00; 0"
    })
    void test(
        @ConvertWith(CsvToStringList.class) List<String> _timePoints,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0539().findMinDifference(_timePoints));
    }

}
