package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1921Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3,4; 1,1,1; 3",
        "1,1,2,3; 1,1,1,1; 1",
        "3,2,4; 5,3,2; 1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _dist,
        @ConvertWith(CsvToIntArray.class) int[] _speed,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1921().eliminateMaximum(_dist, _speed));
    }

}
