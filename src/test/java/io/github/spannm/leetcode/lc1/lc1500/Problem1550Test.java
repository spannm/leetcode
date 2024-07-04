package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1550Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,6,4,1; false",
        "1,2,34,3,4,5,7,23,12; true"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _arr,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem1550().threeConsecutiveOdds(_arr));
    }
}
