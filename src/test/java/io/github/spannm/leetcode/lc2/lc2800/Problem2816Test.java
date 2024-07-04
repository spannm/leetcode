package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2816Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,8,9; 3,7,8",
        "9,9,9; 1,9,9,8"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {
        assertEquals(_expectedResult, new Problem2816().doubleIt(_head));
    }

}
