package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem1474 extends LeetcodeProblem {

    ListNode deleteNodes(ListNode _head, int _m, int _n) {
        ListNode pre = new ListNode(-1);
        ListNode tmp = pre;
        while (_head != null) {
            int mCount = _m;
            while (_head != null && mCount-- > 0) {
                tmp.next = new ListNode(_head.val);
                _head = _head.next;
                tmp = tmp.next;
            }
            int nCount = _n;
            while (_head != null && nCount-- > 0) {
                _head = _head.next;
            }
        }
        return pre.next;
    }

}
