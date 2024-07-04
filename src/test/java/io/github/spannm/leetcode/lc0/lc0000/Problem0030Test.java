package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0030Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "barfoothefoobarman; foo,bar; 0,9",
        "wordgoodgoodgoodbestword; word,good.best,word; []",
        "barfoofoobarthefoobarman; bar,foo,the; 6,9,12"
    })
    void test(
        String _s,
        @ConvertWith(CsvToStringArray.class) String[] _words,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {

        assertEquals(_expectedResult, new Problem0030().findSubstring(_s, _words));
    }

}
