package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0662Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,3,2,5,3,null,9; 4",
        "1,3,2,5,null,null,9,6,null,7; 7"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0662().widthOfBinaryTree(_root));
    }

}
