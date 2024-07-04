package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0150Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,1,+,3,*; 9",
        "4,13,5,/,+; 6",
        "10,6,9,3,+,-11,*,/,*,17,+,5,+; 22"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _tokens,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0150().evalRPN(_tokens));
    }

}
