package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0131Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "aab; [a,a,b],[aa,b]",
        "a; [a]"
    })
    void test(String _str,
        @ConvertWith(CsvToListOfStringLists.class) List<List<String>> _expectedResult) {
        assertEquals(_expectedResult, new Problem0131().partition(_str));
    }

}
