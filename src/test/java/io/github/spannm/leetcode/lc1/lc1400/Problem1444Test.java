package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1444Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "A..,AAA,...; 3; 3",
        "A..,AA.,...; 3; 1",
        "A..,A..,...; 1; 1"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _pizza,
        int _nbPieces,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1444().ways(_pizza, _nbPieces));
    }

}
