package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1505Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4321; 4; 1342",
        "100; 1; 010",
        "36789; 1000; 36789"
    })
    void test(String _num, int _k, String _expectedResult) {
        assertEquals(_expectedResult, new Problem1505().minInteger(_num, _k));
    }

}
