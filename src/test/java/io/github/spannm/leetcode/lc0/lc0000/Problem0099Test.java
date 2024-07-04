package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0099Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,3,null,null,2; 3,1,null,null,2",
        "3,1,4,null,null,2; 2,1,4,null,null,3"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        @ConvertWith(CsvToTreeNode.class) TreeNode _expectedResult) {
        new Problem0099().recoverTree(_root);
        assertEquals(_expectedResult, _root);
    }
}
