package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0456Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4; false",
        "3,1,4,2; true",
        "-1,3,2,0; true"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0456().find132pattern(_nums));
    }

}
