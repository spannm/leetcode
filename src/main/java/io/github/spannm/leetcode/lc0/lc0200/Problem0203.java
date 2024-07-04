package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem0203 extends LeetcodeProblem {

    ListNode removeElements(ListNode _head, int _val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = _head;
        ListNode curr = _head;
        ListNode prev = dummy;
        while (curr != null) {
            if (curr.val == _val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}
