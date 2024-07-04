package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0338Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "2; 0,1,1",
        "5; 0,1,1,2,1,2"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem0338().countBits(_n));
    }

}
