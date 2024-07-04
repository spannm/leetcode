package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0637Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "3,9,20,null,null,15,7; 3.00000,14.50000,11.00000",
        "3,9,20,15,7; 3.00000,14.50000,11.00000"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _root,
        @ConvertWith(CsvToDoubleList.class) List<Double> _expectedResult) {
        assertEquals(_expectedResult, new Problem0637().averageOfLevels(_root));
    }
}
