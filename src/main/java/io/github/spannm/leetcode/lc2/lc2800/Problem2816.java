package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * 2816. Double a Number Represented as a Linked List.
 */
class Problem2816 extends LeetcodeProblem {

    ListNode doubleIt(ListNode _head) {
        _head = reverse(_head);
        ListNode tmp = new ListNode();
        ListNode curr = tmp;
        int mult = 2;
        int carry = 0;
        while (_head != null) {
            int x = _head.val * mult + carry;
            carry = x / 10;
            curr.next = new ListNode(x % 10);
            curr = curr.next;
            _head = _head.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return reverse(tmp.next);
    }

    static ListNode reverse(ListNode _head) {
        ListNode dummy = new ListNode();
        ListNode curr = _head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }
        return dummy.next;
    }

}
