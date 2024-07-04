package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0110Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3,9,20,null,null,15,7; true",
        "1,2,2,3,3,null,null,4,4; false"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0110().isBalanced(_root));
    }

}
