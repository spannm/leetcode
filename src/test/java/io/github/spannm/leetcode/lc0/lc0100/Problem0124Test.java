package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0124Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 6",
        "-10,9,20,null,null,15,7; 42"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0124().maxPathSum(_root));
    }

}
