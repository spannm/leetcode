package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0318Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "abcw,baz,foo,bar,xtfn,abcdef; 16",
        "a,ab,abc,d,cd,bcd,abcd; 4",
        "a,aa,aaa,aaaa; 0"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _words,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0318().maxProduct(_words));
    }
}
