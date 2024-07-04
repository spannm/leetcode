package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0021Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,4; 1,3,4; 1,1,2,3,4,4",
        ";;",
        "; 0; 0"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _list1,
        @ConvertWith(CsvToListNode.class) ListNode _list2,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {

        assertEquals(_expectedResult, new Problem0021().mergeTwoLists(_list1, _list2));
    }

}
