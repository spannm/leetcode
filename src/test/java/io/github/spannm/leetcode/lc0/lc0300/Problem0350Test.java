package io.github.spannm.leetcode.lc0.lc0300;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0350Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,2,1; 2,2; 2,2",
        "4,9,5; 9,4,9,8,4; 4,9"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums1,
        @ConvertWith(CsvToIntArray.class) int[] _nums2,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        int[] actual = new Problem0350().intersect(_nums1, _nums2);
        assertThat(actual).containsExactlyInAnyOrder(_expectedResult);
    }
}
