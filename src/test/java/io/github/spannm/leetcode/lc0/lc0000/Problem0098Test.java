package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0098Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,1,3; true",
        "5,1,4,null,null,3,6; false"
    })
    void test(@ConvertWith(CsvToTreeNode.class) TreeNode _root,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0098().isValidBST(_root));
    }

}
