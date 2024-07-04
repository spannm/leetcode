package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0623Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "4,2,6,3,1,5; 1; 2; 4,1,1,2,null,null,6,3,1,5",
        "4,2,null,3,1; 1; 3; 4,2,null,1,1,3,null,null,1"
    })
    void test(@ConvertWith(CsvToTreeNode.class) TreeNode _root, int _v, int _d, @ConvertWith(CsvToTreeNode.class) TreeNode _expectedResult) {
        assertEquals(_expectedResult, new Problem0623().addOneRow(_root, _v, _d));
    }

}
