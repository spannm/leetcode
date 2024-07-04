package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">21. Merge Two Sorted Lists</a>.
 */
class Problem0021 extends LeetcodeProblem {

    ListNode mergeTwoLists(ListNode _list1, ListNode _list2) {
        ListNode merged = new ListNode(0); // head before merged list
        ListNode curr = merged;

        while (_list1 != null && _list2 != null) {
            if (_list1.val < _list2.val) {
                curr.next = _list1;
                _list1 = _list1.next;
            } else {
                curr.next = _list2;
                _list2 = _list2.next;
            }
            curr = curr.next;
        }

        if (_list1 != null) {
            curr.next = _list1;
        } else {
            curr.next = _list2;
        }

        return merged.next;
    }

}
