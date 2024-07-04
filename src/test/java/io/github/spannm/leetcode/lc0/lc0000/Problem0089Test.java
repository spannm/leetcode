package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0089Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2; 0,1,3,2",
        "1; 0,1"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {
        assertEquals(_expectedResult, new Problem0089().grayCode(_n));
    }

}
