package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0725Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} => [{2}]")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 5; [1],[2],[3],[],[]",
        "1,2,3,4,5,6,7,8,9,10; 3; [1,2,3,4],[5,6,7],[8,9,10]"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        int _k,
        @ConvertWith(CsvToListNodeArray.class) ListNode[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem0725().splitListToParts(_head, _k));
    }

}
