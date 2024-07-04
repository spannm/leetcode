package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2073Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2,3,2; 2; 6",
        "5,1,1,1; 0; 8"
    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _tickets, int _k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem2073().timeRequiredToBuy(_tickets, _k));
    }

}
