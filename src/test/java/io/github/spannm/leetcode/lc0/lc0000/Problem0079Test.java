package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0079Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[A,B,C,E],[S,F,C,S],[A,D,E,E]; ABCCED; true",
        "[A,B,C,E],[S,F,C,S],[A,D,E,E]; SEE; true",
        "[A,B,C,E],[S,F,C,S],[A,D,E,E]; ABCB; false"
    })
    void test(@ConvertWith(CsvToCharMatrix.class) char[][] _board, String _word,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0079().exist(_board, _word));
    }

}
