package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2125Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "011001,000000,010100,001000; 8",
        "000,111,000; 0",
        "0; 0",
        "0,0; 0"
    })
    void test(@ConvertWith(CsvToStringArray.class) String[] _floorPlan,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2125().numberOfBeams(_floorPlan));
    }

}
