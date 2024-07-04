package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1964Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,2; 1,2,3,3",
        "2,2,1; 1,2,1",
        "3,1,5,6,4,2; 1,1,2,3,2,2"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _obstacles,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, Problem1964.longestObstacleCourseAtEachPosition(_obstacles));
    }

}
