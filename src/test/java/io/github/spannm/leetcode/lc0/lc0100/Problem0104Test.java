package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0104Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3,9,20,null,null,15,7; 3",
        "1,null,2; 2"
    })
    void test(@ConvertWith(CsvToTreeNode.class) TreeNode _root, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0104().maxDepth(_root));
    }

}
