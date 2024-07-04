package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">141. Linked List Cycle</a>.
 */
class Problem0141 extends LeetcodeProblem {

    boolean hasCycle(ListNode _head) {
        if (_head == null || _head.next == null) {
            return false;
        }

        ListNode slow = _head;
        ListNode fast = _head.next;

        while (slow != fast) {
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
