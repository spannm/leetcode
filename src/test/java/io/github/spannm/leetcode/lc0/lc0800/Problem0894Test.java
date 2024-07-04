package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0894Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => [{1}]")
    @CsvSource(delimiter = ';', nullValues = {"null", "NULL"}, value = {
        "7; [0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]",
        "3; [0,0,0,]"
    })
    void test(
        int _n,
        @ConvertWith(CsvToListOfTreeNodes.class) List<TreeNode> _expectedResult) {

        assertEquals(_expectedResult, new Problem0894().allPossibleFBT(_n));
    }

}
