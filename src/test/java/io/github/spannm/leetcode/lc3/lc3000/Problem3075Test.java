package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem3075Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 2; 4",
        "1,1,1,1; 2; 1",
        "2,3,4,5; 1; 5"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _happ, int _k, long _expectedResult) {
        assertEquals(_expectedResult, new Problem3075().maximumHappinessSum(_happ, _k));
    }

}
