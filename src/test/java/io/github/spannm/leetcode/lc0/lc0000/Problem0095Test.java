package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0095Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3; [1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]",
        "1; [1]"
    })
    void test(
        int _totalNodes,
        @ConvertWith(CsvToListOfTreeNodes.class) List<TreeNode> _expectedResult) {
        assertEquals(_expectedResult, new Problem0095().generateTrees(_totalNodes));
    }

}
