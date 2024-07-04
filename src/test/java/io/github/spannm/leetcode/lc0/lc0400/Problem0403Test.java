package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0403Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "0,1,3,5,6,8,12,17; true",
        "0,1,2,3,4,8,9,11; false"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _stones,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0403().canCross(_stones));
    }

}
