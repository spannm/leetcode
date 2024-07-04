package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1160Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "cat,bt,hat,tree; atach; 6",
        "hello,world,leetcode; welldonehoneyr; 10"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _words,
        String _chars,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1160().countCharacters(_words, _chars));
    }

}
