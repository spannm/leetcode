package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2448Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], cost [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3,5,2; 2,3,1,14; 8",
        "2,2,2,2,2; 4,2,8,1,3; 0",
        "735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,"
        + "743518; 724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614; 1907611126748"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToIntArray.class) int[] _cost,
        long _expectedResult) {

        assertEquals(_expectedResult, new Problem2448().minCost(_nums, _cost));
    }

}
