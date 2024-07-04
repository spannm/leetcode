package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii/">142. Linked List Cycle II</a>.
 */
class Problem0142 extends LeetcodeProblem {

    ListNode detectCycle(ListNode _head) {
        ListNode fast = _head;
        ListNode slow = _head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = _head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
