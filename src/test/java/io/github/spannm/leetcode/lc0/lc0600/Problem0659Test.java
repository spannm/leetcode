package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0659Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,3,4,5; true",
        "1,2,3,3,4,4,5,5; true",
        "1,2,3,4,4,5; false"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _nums,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0659().isPossible(_nums));
    }

}
