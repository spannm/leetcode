package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0445Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} + {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "7,2,4,3; 5,6,4; 7,8,0,7",
        "2,4,3; 5,6,4; 8,0,7",
        "0; 0; 0"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _listNode1,
        @ConvertWith(CsvToListNode.class) ListNode _listNode2,
        @ConvertWith(CsvToListNode.class) ListNode _expected) {

        assertEquals(_expected, new Problem0445().addTwoNumbers(_listNode1, _listNode2));
    }

}
