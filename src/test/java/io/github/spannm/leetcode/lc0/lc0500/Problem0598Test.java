package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0598Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "3; 3; [2,2],[3,3]; 4",
        "3; 3; [2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]; 4",
        "3; 3; ; 9"
    })
    void test(int _m, int _n, @ConvertWith(CsvToIntMatrix.class) int[][] _ops,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0598().maxCount(_m, _n, _ops));
    }

}
