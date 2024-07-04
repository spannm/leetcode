package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2260Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3,4,2,3,4,7; 4",
        "1,0,5,3; -1",
        "[95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6]; 3",
        "[70,37,70,41,1,62,71,49,38,50,29,76,29,41,22,66,88,18,85,53]; 3"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _cards, int _expectedResult) {

        assertEquals(_expectedResult, new Problem2260().minimumCardPickup(_cards));
    }

}
