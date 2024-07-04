package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2331Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "2,1,3,null,null,0,1; true",
        "0; false"
    })
    void test(@ConvertWith(CsvToTreeNode.class) TreeNode _root, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem2331().evaluateTree(_root));
    }

}
