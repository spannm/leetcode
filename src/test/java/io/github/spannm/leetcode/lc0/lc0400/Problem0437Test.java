package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0437Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "10,5,-3,3,2,null,11,3,-2,null,1; 8; 3",
        "5,4,8,11,null,13,4,7,2,null,null,5,1; 22; 3"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        int _sum,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0437().pathSum(_root, _sum));
    }

}
