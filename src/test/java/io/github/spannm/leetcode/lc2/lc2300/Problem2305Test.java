package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2305Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] cookies=[{0}], children={1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "8,15,10,20,8; 2; 31",
        "6,1,3,2,2,4,1,2; 3; 7"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _cookies,
        int _k,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem2305().distributeCookies(_cookies, _k));
    }

}
