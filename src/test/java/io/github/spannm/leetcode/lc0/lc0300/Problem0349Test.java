package io.github.spannm.leetcode.lc0.lc0300;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0349Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,2,1; 2,2; 2",
        "4,9,5; 9,4,9,8,4; 9,4"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums1,
        @ConvertWith(CsvToIntArray.class) int[] _nums2,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        int[] intersection = new Problem0349().intersection(_nums1, _nums2);

        assertThat(intersection).containsExactlyInAnyOrder(_expectedResult);
    }

}
