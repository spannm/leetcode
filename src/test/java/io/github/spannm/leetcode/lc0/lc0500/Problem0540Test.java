package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0540Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,1,2,3,3,4,4,8,8]; 2",
        "[3,3,7,7,10,11,11]; 10",
        "[1]; 1",
        "[1,1,2]; 2",
        "[1,1,2,2,4,4,5,5,9]; 9"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0540().singleNonDuplicate(_nums));
    }

}
