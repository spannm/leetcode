package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/rotate-list/">61. Rotate List</a>.
 */
class Problem0061 extends LeetcodeProblem {

    ListNode rotateRight(ListNode _head, int _k) {
        if (_head == null) {
            return null;
        }
        ListNode copy = _head;
        int len = 1;
        while (copy.next != null) {
            copy = copy.next;
            len++;
        }
        copy.next = _head; // link the tail and head to make it a circle
        for (int i = len - _k % len; i > 1; i--) {
            _head = _head.next;
        }
        copy = _head.next;
        _head.next = null; // break the circle
        return copy;
    }

}
