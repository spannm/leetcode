package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0127Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "hit; cog; hot,dot,dog,lot,log,cog; 5",
        "hit; cog; hot,dot,dog,lot,log; 0"
    })
    void test(
        String _beginWord,
        String _endWord,
        @ConvertWith(CsvToStringList.class) List<String> _wordList,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0127().ladderLength(_beginWord, _endWord, _wordList));
    }

}
