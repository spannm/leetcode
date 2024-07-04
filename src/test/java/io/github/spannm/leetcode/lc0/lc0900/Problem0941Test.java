package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0941Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,1; false",
        "3,5,5; false",
        "0,3,2,1; true"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _arr, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0941().validMountainArray(_arr));
    }

}
