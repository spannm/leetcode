package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0792Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "abcde; a,bb,acd,ace; 3",
        "dsahjpjauf; ahjpjau,ja,ahbwzgqnuk,tnmlanowax; 2"
    })
    void test(
        String _s,
        @ConvertWith(CsvToStringArray.class) String[] _words,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0792().numMatchingSubseq(_s, _words));
    }

}
