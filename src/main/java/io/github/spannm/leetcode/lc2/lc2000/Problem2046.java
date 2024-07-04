package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * 2046. Sort Linked List Already Sorted Using Absolute Values.
 */
class Problem2046 extends LeetcodeProblem {

    ListNode sortLinkedList(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val < 0) {
                ListNode t = curr.next;
                prev.next = t;
                curr.next = head;
                head = curr;
                curr = t;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

}
