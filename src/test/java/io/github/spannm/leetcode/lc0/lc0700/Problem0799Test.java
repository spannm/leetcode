package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0799Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "1; 1; 1; 0.0000",
        "2; 1; 1; 0.50000",
        "100000009; 33; 17; 1.0000"
    })
    void test(
        int _poured,
        int _queryRow,
        int _queryGlass,
        double _expectedResult) {
        assertEquals(_expectedResult, new Problem0799().champagneTower(_poured, _queryRow, _queryGlass));
    }

}
