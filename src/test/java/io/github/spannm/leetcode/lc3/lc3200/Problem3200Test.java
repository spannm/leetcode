package io.github.spannm.leetcode.lc3.lc3200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem3200Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "2; 4; 3",
        "2; 1; 2",
        "1; 1; 1",
        "10; 1; 2"
    })
    void test(int _red, int _blue, int _expectedResult) {
        assertEquals(_expectedResult, new Problem3200().maxHeightOfTriangle(_red, _blue));
    }
}
