package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>.
 */
class Problem0206 extends LeetcodeProblem {

    ListNode reverseList(ListNode _head) {
        ListNode prev = null;
        while (_head != null) {
            ListNode next = _head.next;
            _head.next = prev;
            prev = _head;
            _head = next;
        }
        return prev;
    }

}
