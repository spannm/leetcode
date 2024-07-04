package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1048Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "a,b,ba,bca,bda,bdca; 4",
        "xbc,pcxbcf,xb,cxbc,pcxbc; 5",
        "abcd,dbqca; 1",
        "abc,abcde; 1"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _words,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem1048().longestStrChain(_words));
    }

}
