package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0101Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,2,3,4,4,3; true",
        "1,2,2,null,3,null,3; false"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _tree,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0101().isSymmetric(_tree));
    }

}
