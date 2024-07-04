package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">25. Reverse Nodes in k-Group</a>.
 */
class Problem0025 extends LeetcodeProblem {

    ListNode reverseKGroup(ListNode _head, int _k) {
        if (_head == null || _head.next == null || _k == 1) {
            return _head;
        }

        int nodeCount = 0;

        ListNode curr = _head;
        while (curr != null) {
            nodeCount++;
            curr = curr.next;
        }

        ListNode prev = null;
        ListNode next = null;
        ListNode newHead = null;
        ListNode tail1 = null;
        ListNode tail2 = _head;

        curr = _head;

        while (nodeCount >= _k) {
            for (int i = 0; i < _k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if (newHead == null) {
                newHead = prev;
            }
            if (tail1 != null) {
                tail1.next = prev;
            }
            tail2.next = curr;
            tail1 = tail2;
            tail2 = curr;
            prev = null;
            nodeCount -= _k;
        }
        return newHead;
    }

}
