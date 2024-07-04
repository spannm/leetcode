package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0100Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] vs. [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 1,2,3; true",
        "1,2; 1,null,2; false",
        "1,2,1; 1,1,2; false"
    })
    void test(
        @ConvertWith(CsvToTreeNode.class) TreeNode _tn1,
        @ConvertWith(CsvToTreeNode.class) TreeNode _tn2,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0100().isSameTree(_tn1, _tn2));
    }

}
