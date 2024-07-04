package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0712Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "sea; eat; 231",
        "delete; leet; 403"
    })
    void test(
        String _s1,
        String _s2,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0712().minimumDeleteSum(_s1, _s2));
    }

}
