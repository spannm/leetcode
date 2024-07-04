package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem0237 extends LeetcodeProblem {

    void deleteNode(ListNode _node) {
        _node.val = _node.next.val;
        _node.next = _node.next.next;
    }

}
