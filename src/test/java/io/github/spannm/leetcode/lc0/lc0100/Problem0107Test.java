package io.github.spannm.leetcode.lc0.lc0100;

import static org.assertj.core.api.Assertions.assertThatList;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0107Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3,9,20,null,null,15,7; [15,7],[9,20],[3]",
        "1; [1]"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {
        List<List<Integer>> result = new Problem0107().levelOrderBottom(_root);
        assertThatList(result).containsExactlyInAnyOrderElementsOf(_expectedResult);
    }

}
