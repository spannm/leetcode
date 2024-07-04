package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0846Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,6,2,3,4,7,8; 3; true",
        "1,2,3,4,5; 4; false",
        "1,1,1,1,1; 1; true",
        "1,2,3; 4; false",
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _hand, int _groupSize, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0846().isNStraightHand(_hand, _groupSize));
    }
}
