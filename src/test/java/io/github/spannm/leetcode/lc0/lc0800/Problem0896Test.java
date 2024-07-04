package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0896Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] => {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,2,3; true",
        "6,5,4,4; true",
        "1,3,2; false",
        "1,1,2; true",
        "-5,-5,-5,-5,-2,-2,-2,-1,-1,-1,0; true"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0896().isMonotonic(_nums));
    }

}
