package io.github.spannm.leetcode.lc2.lc2600;

import static org.assertj.core.api.Assertions.assertThatList;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem2610Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,3,4,1,2,3,1; [1,3,4,2],[1,3],[1]",
        "1,2,3,4; [4,3,2,1]"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {
        List<List<Integer>> result = new Problem2610().findMatrix(_nums);
        assertEquals(_expectedResult.size(), result.size());
        for (int i = 0; i < _expectedResult.size(); i++) {
            assertThatList(result.get(i))
                .hasSameSizeAs(_expectedResult.get(i))
                .hasSameElementsAs(_expectedResult.get(i));
        }
    }
}
