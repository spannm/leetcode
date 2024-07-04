package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0784Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "a1b2; a1b2,a1B2,A1b2,A1B2",
        "3z4; 3z4, 3Z4"
    })
    void test(
        String _str,
        @ConvertWith(CsvToStringList.class) List<String> _expectedResult) {
        assertEquals(_expectedResult, new Problem0784().letterCasePermutation(_str));
    }

}
