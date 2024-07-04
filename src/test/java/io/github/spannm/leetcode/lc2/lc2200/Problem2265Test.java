package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2265Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] vs. [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "4,8,5,0,1,null,6; 5",
        "1; 1"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _node,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem2265().averageOfSubtree(_node));
    }

}
