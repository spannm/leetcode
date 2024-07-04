package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0106Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "9,3,15,20,7; 9,15,7,20,3; 3,9,20,null,null,15,7",
        "-1; -1; -1"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _inOrder,
        @ConvertWith(CsvToIntArray.class) int[] _postOrder,
        @ConvertWith(CsvToTreeNode.class) TreeNode _expectedResult) {

        assertEquals(_expectedResult, new Problem0106().buildTree(_inOrder, _postOrder));

    }

}
