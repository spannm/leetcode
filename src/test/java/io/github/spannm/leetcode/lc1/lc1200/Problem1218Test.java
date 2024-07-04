package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1218Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4; 1; 4",
        "1,3,5,7; 1; 1;",
        "1,5,7,8,5,3,4,2,1; -2; 4"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _arr,
        int _difference,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1218().longestSubsequence(_arr, _difference));
    }

}
