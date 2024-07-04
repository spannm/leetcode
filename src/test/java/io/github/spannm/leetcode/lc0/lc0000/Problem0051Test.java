package io.github.spannm.leetcode.lc0.lc0000;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0051Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4; [.Q..,...Q,Q...,..Q.],[..Q.,Q...,...Q,.Q..]",
        "1; [Q]"
    })
    void test(
        int _n,
        @ConvertWith(CsvToListOfStringLists.class) List<List<String>> _expected) {

        List<List<String>> result = new Problem0051().solveNQueens(_n);
        assertThat(result).containsExactlyInAnyOrderElementsOf(_expected);
    }

}
