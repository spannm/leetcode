package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1239Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "un,iq,ue; 4",
        "cha,r,act,ers; 6",
        "abcdefghijklmnopqrstuvwxyz; 26"
    })
    void test(@ConvertWith(CsvToStringList.class) List<String> _arr, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1239().maxLength(_arr));
    }

}
