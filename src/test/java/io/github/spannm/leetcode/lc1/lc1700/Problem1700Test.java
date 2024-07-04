package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1700Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,1,0,0; 0,1,0,1; 0",
        "1,1,1,0,0,1; 1,0,0,0,1,1; 3"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _students,
        @ConvertWith(CsvToIntArray.class) int[] _sandwiches,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem1700().countStudents(_students, _sandwiches));
    }

}
