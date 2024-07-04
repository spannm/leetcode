package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1482Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "1,10,3,10,2; 3; 1; 3",
        "1,10,3,10,2; 3; 2; -1",
        "7,7,7,7,12,7,7; 2; 3; 12"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _bloomDay,
        int _nbBouquets,
        int _nbAdjFlowers,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem1482().minDays(_bloomDay, _nbBouquets, _nbAdjFlowers));
    }

}
