package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0501Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,null,2,2; 2",
        "0; 0"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {
        assertArrayEquals(_expectedResult, new Problem0501().findMode(_root));
    }

}
