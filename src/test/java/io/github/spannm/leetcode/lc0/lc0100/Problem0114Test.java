package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0114Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,5,3,4,null,6; 1,null,2,null,3,null,4,null,5,null,6",
        ";",
        "0; 0"
    })
    void test(
        @ConvertWith(LeetcodeBaseTest.CsvToTreeNode.class) TreeNode _root,
        @ConvertWith(LeetcodeBaseTest.CsvToTreeNode.class) TreeNode _expectedResult) {
        new Problem0114().flatten(_root);
        assertEquals(_expectedResult, _root);
    }

}
