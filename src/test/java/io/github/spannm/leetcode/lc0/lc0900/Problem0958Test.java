package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0958Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5,6; true",
        "1,2,3,4,5,null,7; false",
        "1,2,3,5,null,7,8; false",
        "1,2,3,5; true"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _tree,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0958().isCompleteTree(_tree));
    }

}
