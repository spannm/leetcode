package io.github.spannm.leetcode.lc1.lc1200;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1203Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, [{2}], [{3}] --> [{4}]")
    @CsvSource(delimiter = ';', value = {
        "8; 2; -1,-1,1,0,0,1,0,-1;[],[6],[5],[6],[3,6],[],[],[]; 6,3,4,1,5,2,0,7",
        "8; 2; -1,-1,1,0,0,1,0,-1;[],[6],[5],[6],[3],[],[4],[];"
    })
    void test(
        int _itemCount,
        int _groupCount,
        @ConvertWith(CsvToIntArray.class) int[] _groups,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _beforeItems,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        int[] result = new Problem1203().sortItems(
            _itemCount, _groupCount, _groups, _beforeItems);
        assertThat(result).containsExactlyInAnyOrder(_expectedResult);
    }

}
