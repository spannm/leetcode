package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0112Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5,4,8,11,null,13,4,7,2,null,null,null,1; 22; true",
        "1,2,3; 5; false",
        "; 0; false"
    })
    void test(@ConvertWith(CsvToTreeNode.class) TreeNode _root, int _sum,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0112().hasPathSum(_root, _sum));
    }

}
