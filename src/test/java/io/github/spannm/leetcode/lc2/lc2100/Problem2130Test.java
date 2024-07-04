package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2130Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "5,4,2,1; 6",
        "4,2,2,3; 7",
        "1,100000; 100001"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _head,
        int _expectedResult) {
        assertEquals(_expectedResult, Problem2130.pairSum(_head));
    }

}
