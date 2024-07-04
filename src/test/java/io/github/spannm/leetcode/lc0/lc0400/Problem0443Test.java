package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0443Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> len={1}, [{2}]")
    @CsvSource(delimiter = ';', value = {
        "a,a,b,b,c,c,c; 6; a,2,b,2,c,3",
        "a; 1; a",
        "a,b,b,b,b,b,b,b,b,b,b,b,b; 4; a,b,1,2",
        "a,b,c; 3; a,b,c"
    })
    void test(
        @ConvertWith(CsvToCharArray.class) char[] _input,
        int _expectedLength,
        @ConvertWith(CsvToCharArray.class) char[] _expectedArray) {

        int length = new Problem0443().compress(_input);
        assertEquals(_expectedLength, length);
        for (int i = 0; i < _expectedArray.length; i++) {
            assertEquals(_expectedArray[i], _input[i], "Array differs at index " + i);
        }
    }

}
