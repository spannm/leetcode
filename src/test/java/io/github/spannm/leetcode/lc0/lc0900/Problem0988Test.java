package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0988Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "0,1,2,3,4,3,4; dba",
        "25,1,3,1,3,0,2; adz",
        "2,2,1,null,1,0,null,0; abc"
    })
    void test(@ConvertWith(CsvToTreeNode.class) TreeNode _root, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0988().smallestFromLeaf(_root));
    }

}
