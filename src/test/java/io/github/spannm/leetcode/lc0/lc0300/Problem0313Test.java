package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0313Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "12; 2,7,13,19; 32",
        "1; 2,3,5; 1",
        "5911; 2,3,5,7; 2144153025"
    })
    void test(int _n, @ConvertWith(CsvToIntArray.class) int[] _primes,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0313().nthSuperUglyNumber(_n, _primes));
    }
}
