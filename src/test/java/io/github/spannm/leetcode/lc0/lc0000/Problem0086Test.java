package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0086Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} => {2}")
    @CsvSource(delimiter = ';', value = {
        "1,4,3,2,5,2; 3; 1,2,2,4,3,5",
        "2,1; 2; 1,2"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        int _x,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {

        ListNode result = new Problem0086().partition(_head, _x);
        assertEquals(_expectedResult, result);
    }

}
