package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1601Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] buildings={0}, requests=[{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5; [0,1],[1,0],[0,1],[1,2],[2,0],[3,4]; 5",
        "3; [0,0],[1,2],[2,1]; 3",
        "4; [0,3],[3,1],[1,2],[2,0]; 4"
    })
    void test(
        int _n,
        @ConvertWith(CsvToIntMatrix.class) int[][] _requests,
        int _expectedResult) {

        assertEquals(_expectedResult, Problem1601.maximumRequests(_n, _requests));
    }

}
