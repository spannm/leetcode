package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0880Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "leet2code3; 10; o",
        "ha22; 5; h",
        "a2345678999999999999999; 1; a",
        "y959q969u3hb22odq595; 222280369; y"
    })
    void test(
        String _s,
        int _k,
        String _expectedResult) {

        assertEquals(_expectedResult, new Problem0880().decodeAtIndex(_s, _k));
    }

}
