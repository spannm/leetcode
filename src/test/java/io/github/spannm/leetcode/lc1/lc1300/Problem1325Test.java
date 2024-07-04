package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1325Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,2,null,2,4; 2; 1,null,3,null,4",
        "1,3,3,3,2; 3; 1,3,null,null,2",
        "1,2,null,2,null,2; 2; 1"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        int _target,
        @ConvertWith(CsvToTreeNode.class) TreeNode _expectedResult) {
        assertEquals(_expectedResult, new Problem1325().removeLeafNodes(_root, _target));
    }

}
