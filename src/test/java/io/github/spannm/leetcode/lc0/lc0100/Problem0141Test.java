package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.dep.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0141Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "3,2,0,-4; true"
    })
    void test1(
        Object _dummy1,
        boolean _dummy2) {

        ListNode head = new ListNode(3);
        ListNode n3 = head;
        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        ListNode nneg4 = new ListNode(-4);

        n3.next = n2;
        n2.next = n0;
        n0.next = nneg4;
        nneg4.next = n2;

        assertTrue(new Problem0141().hasCycle(head));
    }

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2; true"
    })
    void test2(
        Object _dummy1,
        boolean _dummy2) {

        ListNode head = new ListNode(1);
        ListNode n1 = head;
        ListNode n2 = new ListNode(2);

        n1.next = n2;
        n2.next = n1;

        assertTrue(new Problem0141().hasCycle(head));
    }

    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(delimiter = ';', value = {
        "1; false"
    })
    void test3(
        Object _dummy1,
        boolean _dummy2) {

        ListNode head = new ListNode(1);

        assertFalse(new Problem0141().hasCycle(head));
    }

}
