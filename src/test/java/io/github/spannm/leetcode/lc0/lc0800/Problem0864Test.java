package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0864Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "@.a..,###.#,b.A.B; 8",
        "@..aA,..B#.,....b; 6",
        "@Aa; -1"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _grid,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem0864.shortestPathAllKeys(_grid));
    }

}
