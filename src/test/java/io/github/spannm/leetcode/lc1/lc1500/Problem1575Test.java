package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1575Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,3,6,8,4; 1; 3; 5; 4",
        "4,3,1; 1; 0; 6; 5",
        "5,2,1; 0; 2; 3; 0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _locations,
        int _start,
        int _finish,
        int _fuel,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1575().countRoutes(_locations, _start, _finish, _fuel));
    }

}
