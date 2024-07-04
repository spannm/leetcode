package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2369Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4,4,4,5,6; true",
        "1,1,1,2; false"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem2369().validPartition(_nums));
    }

}
