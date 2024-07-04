package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

@Disabled
class Problem0863Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, {2} --> {3}")
    @CsvSource(delimiter = ';', nullValues = {"null"}, value = {
        "3,5,1,6,2,0,8,null,null,7,4; 5; 2; 7,4,1",
        "1; 1; 3;"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        @ConvertWith(CsvToTreeNode.class) TreeNode _target,
        int _k,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {

        assertEquals(_expectedResult, new Problem0863().distanceK(_root, _target, _k));
    }

}
