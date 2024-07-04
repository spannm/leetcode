package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0142Test extends LeetcodeBaseTest {

    @Disabled("Cannot set up test data")
    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "3,2,0,-4; 1",
        "1,2; 0",
        "1; -1"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {

        assertEquals(_expectedResult, new Problem0142().detectCycle(_head));
    }

}
