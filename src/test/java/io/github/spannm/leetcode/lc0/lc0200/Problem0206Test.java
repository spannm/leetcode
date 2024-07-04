package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0206Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] => [{1}]")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5; 5,4,3,2,1",
        "1,2; 2,1",
        ";"
    })
    void test(
        @ConvertWith(CsvToListNode.class) ListNode _list,
        @ConvertWith(CsvToListNode.class) ListNode _expectedResult) {

        assertEquals(_expectedResult, new Problem0206().reverseList(_list));
    }

}
