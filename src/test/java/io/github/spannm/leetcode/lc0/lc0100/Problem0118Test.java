package io.github.spannm.leetcode.lc0.lc0100;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.spannm.leetcode.LeetcodeBaseTest.CsvToListOfIntegerLists;
import io.github.spannm.leetcode.LeetcodeProblem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0118Test extends LeetcodeProblem {

    @ParameterizedTest(name = "[{index}] {0} --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "5; [1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]",
        "1; [1]"
    })
    void test(
        int _numRows,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {

        assertEquals(_expectedResult, new Problem0118().generate(_numRows));
    }

}
