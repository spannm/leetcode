package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0134Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5; 3,4,5,1,2; 3",
        "2,3,4; 3,4,3; -1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _gas,
        @ConvertWith(CsvToIntArray.class) int[] _cost,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0134().canCompleteCircuit(_gas, _cost));
    }

}
