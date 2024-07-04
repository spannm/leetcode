package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2616Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "10,1,2,7,1,3]; 2; 1",
        "4,2,1,2; 1; 0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _p,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem2616().minimizeMax(_nums, _p));
    }

}
