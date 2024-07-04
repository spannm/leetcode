package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0014Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource(delimiter = ';', value = {
        "flower,flow,flight; fl",
        "dog,racecar,car; ''",
        "abc,abc, ''; ''",
        "abc,abcdef,abcdefghi;abc"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _input,
        String _expectedResult) {
        assertEquals(_expectedResult, new Problem0014().longestCommonPrefix(_input));
    }

}
