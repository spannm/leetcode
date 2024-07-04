package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0948Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "100; 50; 0",
        "200,100; 150; 1",
        "100,200,300,400; 200; 2"

    })
    void test(@ConvertWith(CsvToIntArray.class) int[] _tokens, int _power, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0948().bagOfTokensScore(_tokens, _power));
    }

}
