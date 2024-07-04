package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0234Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,2,1; true",
        "1,2; false"
    })
    void test(@ConvertWith(CsvToListNode.class) ListNode _head, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0234().isPalindrome(_head));
    }

}
