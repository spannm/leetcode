package io.github.spannm.leetcode.lc0.lc0500;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class Problem0587Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]; [1,1],[2,0],[4,2],[3,3],[2,4]",
        "[1,2],[2,2],[4,2]; [4,2],[2,2],[1,2]"
    })
    void test(
        @ConvertWith(CsvToIntMatrix.class) int[][] _trees,
        @ConvertWith(CsvToIntMatrix.class) int[][] _expectedResult) {

        int[][] result = new Problem0587().outerTrees(_trees);

        Arrays.sort(_expectedResult, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        Arrays.sort(result, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        assertThat(result).hasSameDimensionsAs(_expectedResult);
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i]).containsExactly(_expectedResult[i]);
        }
    }

}
