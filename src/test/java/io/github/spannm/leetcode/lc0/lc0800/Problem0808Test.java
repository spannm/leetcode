package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0808Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "50; 0.62500",
        "100; 0.71875"
    })
    void test(
        int _totalMl,
        double _expectedResult) {

        assertEquals(_expectedResult, new Problem0808().soupServings(_totalMl));
    }

}
