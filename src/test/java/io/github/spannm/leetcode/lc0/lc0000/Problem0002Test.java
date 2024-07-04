package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0002Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    @CsvSource(delimiter = ';', value = {
        "2,4,3; 5,6,4; 7,0,8",
        "0; 0; 0",
        "9,9,9,9,9,9,9; 9,9,9,9; 8,9,9,9,0,0,0,1",
        "9; 1,9,9,9,9,9,9,9,9,9; 0,0,0,0,0,0,0,0,0,0,1",
        "1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1; 5,6,4; 6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1"
    })
    void test(@ConvertWith(CsvToListNode.class) ListNode _ln1,
        @ConvertWith(CsvToListNode.class) ListNode _ln2,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {
        assertEquals(_expectedResult, new Problem0002().addTwoNumbers(_ln1, _ln2));
    }

}
