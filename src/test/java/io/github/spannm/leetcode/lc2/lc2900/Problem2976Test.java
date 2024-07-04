package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2976Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2}; {3}; {4} --> {5}")
    @CsvSource(delimiter = ';', value = {
        "abcd; acbe; a,b,c,c,e,d; b,c,b,e,b,e; 2,5,5,1,2,20; 28",
        "aaaa; bbbb;a,c; c,b; 1,2; 12",
        "abcd; abce; a; e; 10000; -1"
    })
    void test(
        String _source,
        String _target,
        @ConvertWith(CsvToCharArray.class) char[] _orig,
        @ConvertWith(CsvToCharArray.class) char[] _changed,
        @ConvertWith(CsvToIntArray.class) int[] _cost,
        long _expectedResult) {
        assertEquals(_expectedResult, new Problem2976().minimumCost(_source, _target, _orig, _changed, _cost));
    }

}
