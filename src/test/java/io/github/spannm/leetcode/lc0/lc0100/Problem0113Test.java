package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0113Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5,4,8,11,null,13,4,7,2,null,null,5,1; 22; [5,4,11,2],[5,8,4,5]",
        "1,2,3; 5; ",
        "1,2; 0; "
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        int _sum,
        @ConvertWith(CsvToListOfIntegerLists.class) List<List<Integer>> _expectedResult) {
        assertEquals(_expectedResult, new Problem0113().pathSum(_root, _sum));
    }

}
