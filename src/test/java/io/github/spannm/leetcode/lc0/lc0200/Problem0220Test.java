package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0220Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,1; 3; 0; true",
        "1,5,9,1,5,9; 2; 3; false"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _k,
        int _t,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0220().containsNearbyAlmostDuplicate(_nums, _k, _t));
    }

}
