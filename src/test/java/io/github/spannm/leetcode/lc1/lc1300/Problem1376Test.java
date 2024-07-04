package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1376Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, headId={1}, staff=[{2}], times=[{3}] --> {4}")
    @CsvSource(delimiter = ';', value = {
        "1; 0; -1; 0; 0",
        "6; 2; 2,2,-1,2,2,2; 0,0,1,0,0,0; 1",
        "15; 0; -1,0,0,1,1,2,2,3,3,4,4,5,5,6,6; 1,1,1,1,1,1,1,0,0,0,0,0,0,0,0; 3"
    })
    void test(
        int _count,
        int _headId,
        @ConvertWith(CsvToIntArray.class) int[] _staff,
        @ConvertWith(CsvToIntArray.class) int[] _times,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1376().numOfMinutes(_count, _headId, _staff, _times));
    }

}
