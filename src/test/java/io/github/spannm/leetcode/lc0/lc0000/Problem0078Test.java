package io.github.spannm.leetcode.lc0.lc0000;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0078Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]",
        "0; [],[0]"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {
        assertThat(new Problem0078().subsets(_nums)).containsAll(_expectedResult);
    }

}
