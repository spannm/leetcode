package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0145Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,null,2,3; 3,2,1",
        "; ",
        "1; 1"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {
        assertEquals(_expectedResult, new Problem0145().postorderTraversal(_root));
    }

}
