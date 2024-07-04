package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0652Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,null,2,4,null,null,4; [2,4],[4]",
        "2,1,1; [1]",
        "2,2,2,3,null,3,null; [2,3],[3]"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        @ConvertWith(CsvToListOfTreeNodes.class) List<TreeNode> _expectedResult) {

        List<TreeNode> result = new Problem0652().findDuplicateSubtrees(_root);
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(_expectedResult);
    }

}
