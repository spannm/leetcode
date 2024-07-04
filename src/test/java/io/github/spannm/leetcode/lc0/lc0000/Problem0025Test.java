package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0025Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5; 2; 2,1,4,3,5",
        "1,2,3,4,5; 3; 3,2,1,4,5"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        int _k,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {
        assertEquals(_expectedResult, new Problem0025().reverseKGroup(_head, _k));
    }

}
