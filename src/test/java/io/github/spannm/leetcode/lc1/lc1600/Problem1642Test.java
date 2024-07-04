package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1642Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "4,2,7,6,9,14,12; 5; 1; 4",
        "4,12,2,7,3,18,20,3,19; 10; 2; 7"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _heights, int _bricks, int _ladders, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1642().furthestBuilding(_heights, _bricks, _ladders));
    }

}
