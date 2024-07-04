package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1721Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5; 2; 1,4,3,2,5",
        "7,9,6,6,7,8,3,0,9,5; 5; 7,9,6,6,8,7,3,0,9,5",
        "1; 1; 1",
        "1,2,3; 2; 1,2,3"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        int _k,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {
        assertEquals(_expectedResult, Problem1721.swapNodes(_head, _k));
    }

}
