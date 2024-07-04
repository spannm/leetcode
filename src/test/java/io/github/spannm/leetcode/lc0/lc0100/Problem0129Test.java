package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0129Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 25",
        "4,9,0,5,1; 1026",
        "815; 815"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0129().sumNumbers(_root));
    }

}
