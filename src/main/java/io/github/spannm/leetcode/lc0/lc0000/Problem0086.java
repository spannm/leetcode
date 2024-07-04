package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/partition-list/">86. Partition List</a>.
 */
class Problem0086 extends LeetcodeProblem {

    ListNode partition(ListNode _head, final int _x) {
        final int invalidVal = -101;

        ListNode lessBgn = new ListNode(invalidVal);
        ListNode less = lessBgn;
        ListNode grtrBgn = new ListNode(invalidVal);
        ListNode grtr = grtrBgn;

        while (_head != null) {
            if (_head.val < _x) {
                less.next = _head;
                less = _head;
            } else {
                grtr.next = _head;
                grtr = _head;
            }
            _head = _head.next;
        }

        less.next = null;
        grtr.next = null;

        ListNode result = null;
        if (less.val > invalidVal) {
            result = lessBgn.next;
        }
        if (grtr.val > invalidVal) {
            if (result == null) {
                result = grtrBgn.next;
            } else {
                less.next = grtrBgn.next;
            }
        }

        return result;
    }

}
