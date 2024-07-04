package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0744Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "c,f,j; a; c",
        "c,f,j; c; f",
        "x,x,y,y; z; x"
    })
    void test(
        @ConvertWith(CsvToCharArray.class) char[] _letters,
        char _target,
        char _expectedResult) {
        assertEquals(_expectedResult, Problem0744.nextGreatestLetter(_letters, _target));
    }

}
