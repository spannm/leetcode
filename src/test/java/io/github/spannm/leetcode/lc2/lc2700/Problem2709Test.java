package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2709Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,3,6; true",
        "3,9,5; false",
        "4,3,12,8; true"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem2709().canTraverseAllPairs(_nums));
    }

}
