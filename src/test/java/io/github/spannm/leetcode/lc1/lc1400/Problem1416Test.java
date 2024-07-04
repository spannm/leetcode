package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1416Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, range [1,{1}] --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "1000; 10000; 1",
        "1000; 10; 0",
        "1317; 2000; 8"
    })
    void test(
        String _str,
        int _range,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem1416.numberOfArrays(_str, _range));
    }

}
