package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/sort-list/">148. Sort List</a>.
 */
class Problem0148 extends LeetcodeProblem {

    ListNode sortList(ListNode _head) {
        if (_head == null || _head.next == null) {
            return _head;
        }

        ListNode prev = null;
        ListNode slow = _head;
        ListNode fast = _head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;

        return merge(sortList(_head), sortList(slow));
    }

    static ListNode merge(ListNode _n1, ListNode _n2) {
        ListNode result = new ListNode(0);
        ListNode tmp = result;

        while (_n1 != null && _n2 != null) {
            if (_n1.val < _n2.val) {
                tmp.next = _n1;
                _n1 = _n1.next;
            } else {
                tmp.next = _n2;
                _n2 = _n2.next;
            }
            tmp = tmp.next;
        }

        if (_n1 != null) {
            tmp.next = _n1;
        }
        if (_n2 != null) {
            tmp.next = _n2;
        }
        return result.next;
    }

}
