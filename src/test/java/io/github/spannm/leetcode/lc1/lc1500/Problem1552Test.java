package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1552Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,7; 3; 3",
        "5,4,3,2,1,1000000000; 2; 999999999"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _basketPositions, int _nbBalls, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1552().maxDistance(_basketPositions, _nbBalls));
    }
}
