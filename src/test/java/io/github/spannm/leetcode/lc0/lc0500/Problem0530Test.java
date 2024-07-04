package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0530Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "4,2,6,1,3; 1",
        "1,0,48,null,null,12,49; 1",
        "236,104,701,null,227,null,911; 9"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0530().getMinimumDifference(_root));
    }

}
