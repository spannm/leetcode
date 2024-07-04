package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1862Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,5,9; 10",
        "7,7,7,7,7,7,7; 49"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1862().sumOfFlooredPairs(_nums));
    }

}
