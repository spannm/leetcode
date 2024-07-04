package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2300Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] spells={0}, spells={1}, success {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "5,1,3; 1,2,3,4,5; 7; 4,0,3",
        "3,1,2; 8,5,8; 16; 2,0,2"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _spells,
        @ConvertWith(CsvToIntArray.class) int[] _potions,
        long _success,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem2300().successfulPairs(_spells, _potions, _success));
    }

}
