package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1639Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], target={1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "acca,bbbb,caca; aba; 6",
        "abba,baab; bab; 4"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _words,
        String _target,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1639().numWays(_words, _target));
    }

}
