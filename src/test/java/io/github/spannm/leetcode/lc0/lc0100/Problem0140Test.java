package io.github.spannm.leetcode.lc0.lc0100;

import static org.assertj.core.api.Assertions.assertThatList;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0140Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "catsanddog; cat,cats,and,sand,dog; cats and dog,cat sand dog",
        "pineapplepenapple; apple,pen,applepen,pine,pineapple; pine apple pen apple,pineapple pen apple,pine applepen apple",
        "catsandog; cats,dog,sand,and,cat; "
    })
    void test(
        String _s,
        @ConvertWith(CsvToStringList.class) List<String> _wordDict,
        @ConvertWith(CsvToStringList.class) List<String> _expectedResult) {
        List<String> result = new Problem0140().wordBreak(_s, _wordDict);
        assertThatList(result).containsAll(_expectedResult);
    }

}
