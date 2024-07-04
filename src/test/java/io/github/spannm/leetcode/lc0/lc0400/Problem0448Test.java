package io.github.spannm.leetcode.lc0.lc0400;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0448Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4,3,2,7,8,2,3,1; 5,6",
        "1,1; 2"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {

        List<Integer> result = new Problem0448().findDisappearedNumbers(_nums);
        assertThat(result).containsExactlyInAnyOrderElementsOf(_expectedResult);
    }

}
