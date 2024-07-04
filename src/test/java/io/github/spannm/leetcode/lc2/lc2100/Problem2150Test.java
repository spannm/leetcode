package io.github.spannm.leetcode.lc2.lc2100;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem2150Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "10,6,5,8; 10,8",
        "1,3,5,3; 1,5"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {

        assertThat(new Problem2150().findLonely(_nums)).hasSameElementsAs(_expectedResult);
    }

}
