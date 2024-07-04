package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem0083 extends LeetcodeProblem {

    ListNode deleteDuplicates(ListNode _head) {
        ListNode pre = new ListNode(-1);
        pre.next = _head;
        while (_head != null) {
            while (_head.next != null && _head.next.val == _head.val) {
                _head.next = _head.next.next;
            }
            _head = _head.next;
        }
        return pre.next;
    }

}
