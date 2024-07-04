package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2037Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "3,1,5; 2,7,4; 4",
        "4,1,5,9; 1,3,2,6; 7",
        "2,2,6,6; 1,3,2,6; 4"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _seats,
        @ConvertWith(CsvToIntArray.class) int[] _students,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2037().minMovesToSeat(_seats, _students));
    }

}
