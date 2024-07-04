package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1539Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, target {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2,3,4,7,11; 5; 9",
        "1,2,3,4; 2; 6"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _arr,
        int _k,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1539().findKthPositive(_arr, _k));
    }

}
