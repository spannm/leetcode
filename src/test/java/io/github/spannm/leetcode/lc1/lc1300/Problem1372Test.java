package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1372Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1; 3",
        "1,1,1,null,1,null,null,1,1,null,1; 4",
        "1; 0"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem1372().longestZigZag(_root));
    }

}
