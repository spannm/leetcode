package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">92. Reverse Linked List II</a>.
 */
class Problem0092 extends LeetcodeProblem {

    ListNode reverseBetween(final ListNode _head, int _left, int _right) {
        List<Integer> vals = new ArrayList<>();

        ListNode node = _head;

        while (node != null) {
            vals.add(node.val);
            node = node.next;
        }
        _left = _left - 1;
        _right = _right - 1;

        while (_left < _right) {
            int vl = vals.get(_left);
            vals.set(_left, vals.get(_right));
            vals.set(_right, vl);
            _left++;
            _right--;
        }

        ListNode rtn = new ListNode(-1);
        node = rtn;

        for (Integer v : vals) {
            node.next = new ListNode(v);
            node = node.next;
        }

        return rtn.next;
    }

}
