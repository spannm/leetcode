package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0130Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[X,X,X,X],[X,O,O,X],[X,X,O,X],[X,O,X,X]; [X,X,X,X],[X,X,X,X],[X,X,X,X],[X,O,X,X]",
        "[X]; [X]"
    })
    void test(
        @ConvertWith(LeetcodeBaseTest.CsvToCharMatrix.class) char[][] _board,
        @ConvertWith(LeetcodeBaseTest.CsvToCharMatrix.class) char[][] _expectedResult) {

        new Problem0130().solve(_board);
        assertArrayEquals(_expectedResult, _board);

    }

}
