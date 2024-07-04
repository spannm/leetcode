package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0147Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4,2,1,3; 1,2,3,4",
        "-1,5,3,4,0; -1,0,3,4,5"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {
        assertEquals(_expectedResult, new Problem0147().insertionSortList(_head));
    }

}
