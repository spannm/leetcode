package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/">1721. Swapping Nodes in a Linked List</a>.
 */
class Problem1721 extends LeetcodeProblem {

    static ListNode swapNodes(ListNode _head, int _k) {
        int len = 0;
        ListNode a = null;
        ListNode b = null;

        ListNode ptr = _head;
        while (ptr != null) {
            len++;
            ptr = ptr.next;
        }
        if (len == 1) {
            return _head;
        }

        ptr = _head;
        for (int i = 1; i <= len; i++, ptr = ptr.next) {
            if (i == _k) {
                a = ptr;
            }
            if (i == len + 1 - _k) {
                b = ptr;
            }
        }

        if (a != b) {
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;
        }

        return _head;
    }

}
