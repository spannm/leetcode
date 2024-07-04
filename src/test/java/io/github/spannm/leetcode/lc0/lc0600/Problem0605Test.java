package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0605Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] plant {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,0,0,0,1; 1; true",
        "1,0,0,0,1; 2; false",
        "1,0,1,0,1,0,1; 0; true"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _flowerbed,
        int _n,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0605().canPlaceFlowers(_flowerbed, _n));
    }

}
