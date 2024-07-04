package io.github.spannm.leetcode.lc0.lc0000;

import static org.assertj.core.api.Assertions.assertThatList;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0077Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] n={0}, k={1} => {2}")
    @CsvSource(delimiter = ';', value = {
        "4; 2; [1,2],[1,3],[1,4],[2,3],[2,4],[3,4]",
        "1; 1; [1]"
    })
    void test(
        int _n,
        int _k,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {

        List<List<Integer>> result = new Problem0077().combine(_n, _k);
        assertThatList(result).containsExactlyInAnyOrderElementsOf(_expectedResult);
    }

}
