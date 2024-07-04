package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0108Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "-10,-3,0,5,9; 0,-10,5,null,-3,null,9",
        "1,3; 1,null,3"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _num,
        @ConvertWith(CsvToTreeNode.class) TreeNode _expectedResult) {
        TreeNode result = new Problem0108().sortedArrayToBST(_num);
        assertEquals(_expectedResult, result);
    }

}
