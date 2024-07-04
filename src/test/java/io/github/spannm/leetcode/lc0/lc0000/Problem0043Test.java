package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0043Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2; 3; 6",
        "123; 456; 56088"
    })
    void test(String _num1, String _num2, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0043().multiply(_num1, _num2));
    }

}
