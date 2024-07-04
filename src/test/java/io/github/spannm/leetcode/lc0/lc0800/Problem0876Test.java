package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0876Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] => [{1}]")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5; 3,4,5",
        "1,2,3,4,5,6; 4,5,6",
        "1; 1"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {

        assertEquals(_expectedResult, new Problem0876().middleNode(_head));
    }

}
