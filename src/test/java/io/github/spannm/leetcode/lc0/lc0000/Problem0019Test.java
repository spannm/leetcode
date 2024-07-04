package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0019Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], nth={1} => [{2}]")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5; 2; 1,2,3,5",
        "1; 1;",
        "1,2; 1; 1",
        "1,2; 2; 2"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        int _n,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {

        assertEquals(_expectedResult, new Problem0019().removeNthFromEnd(_head, _n));
    }

}
