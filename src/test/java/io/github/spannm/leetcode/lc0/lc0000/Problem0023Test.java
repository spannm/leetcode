package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0023Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "[1,4,5],[1,3,4],[2,6]; [1,1,2,3,4,4,5,6]",
        "[]; []",
        "[]; []"
    })
    void test(
        @ConvertWith(CsvToListNodeArray.class) ListNode[] _lists,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {

        assertEquals(_expectedResult, new Problem0023().mergeKLists(_lists));
    }

}
