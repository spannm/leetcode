package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">24. Swap Nodes in Pairs</a>.
 */
class Problem0024 extends LeetcodeProblem {

    ListNode swapPairs(ListNode _head) {
        if (_head == null || _head.next == null) {
            return _head;
        }
        ListNode n1 = new ListNode(0);
        ListNode n2 = n1;
        n1.next = _head;
        while (_head != null && _head.next != null) {
            n2.next = _head.next;
            _head.next = _head.next.next;
            n2.next.next = _head;
            n2 = n2.next.next;
            _head = _head.next;
        }
        return n1.next;
    }

}
