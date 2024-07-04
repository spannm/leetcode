package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0966Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "KiTe,kite,hare,Hare; kite,Kite,KiTe,Hare,HARE,Hear,hear,keti,keet,keto; kite,KiTe,KiTe,Hare,hare,,,KiTe,,KiTe",
        "yellow; YellOw; yellow"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _wordlist,
        @ConvertWith(CsvToStringArray.class) String[] _queries,
        @ConvertWith(CsvToStringArray.class) String[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0966().spellchecker(_wordlist, _queries));
    }
}
