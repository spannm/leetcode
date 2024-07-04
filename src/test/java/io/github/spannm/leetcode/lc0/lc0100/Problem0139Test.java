package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0139Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "leetcode; leet,code; true",
        "applepenapple; apple,pen; true",
        "catsandog; cats,dog,sand,and,cat; false"
    })
    void test(
        String _str,
        @ConvertWith(CsvToStringList.class) List<String> _wordDict,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0139().wordBreak(_str, _wordDict));
    }

}
