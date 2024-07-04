package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2707Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "leetscode; leet,code,leetcode; 1",
        "sayhelloworld; hello,world; 3"
    })
    void test(
        String _s,
        @ConvertWith(CsvToStringArray.class) String[] _dictionary,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem2707().minExtraChar(_s, _dictionary));
    }

}
