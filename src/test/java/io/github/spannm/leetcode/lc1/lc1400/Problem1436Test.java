package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1436Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[London,New York],[New York,Lima],[Lima,Sao Paulo]; Sao Paulo",
        "[B,C],[D,B],[C,A]; A"
    })
    void test(
        @ConvertWith(CsvToListOfStringLists.class) List<List<String>> _paths,
        String _expectedResult) {
        assertEquals(_expectedResult, new Problem1436().destCity(_paths));
    }

}
