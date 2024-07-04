package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2187Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], totalTrips={1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 5; 3",
        "2; 1; 2",
        "10000; 10000000; 100000000000"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _time,
        int _totalTrips,
        long _expectedResult) {
        assertEquals(_expectedResult, new Problem2187().minimumTime(_time, _totalTrips));
    }

}
