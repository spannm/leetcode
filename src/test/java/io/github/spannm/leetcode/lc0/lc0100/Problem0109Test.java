package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0109Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "-10,-3,0,5,9; 0,-3,9,-10,null,5",
        "; "
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        @ConvertWith(CsvToTreeNode.class) TreeNode _expectedResult) {
        assertEquals(_expectedResult, new Problem0109().sortedListToBST(_head));
    }

}
