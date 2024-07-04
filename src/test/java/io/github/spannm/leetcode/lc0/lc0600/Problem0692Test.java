package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0692Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "i,love,leetcode,i,love,coding; 2; i,love",
        "the,day,is,sunny,the,the,the,sunny,is,is; 4; the,is,sunny,day"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _words,
        int _k,
        @ConvertWith(CsvToStringList.class) List<String> _expectedResult) {
        assertEquals(_expectedResult, new Problem0692().topKFrequent(_words, _k));
    }

}
