package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0665Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4,2,3; true",
        "4,2,1; false"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0665().checkPossibility(_nums));
    }

}
