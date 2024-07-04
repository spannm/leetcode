package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1442Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,3,1,6,7; 4",
        "1,1,1,1,1; 10"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _arr, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1442().countTriplets(_arr));
    }

}
