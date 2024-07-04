package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0430 extends LeetcodeProblem {

    Node flatten(Node _head) {
        if (_head == null) {
            return null;
        }
        Node pre = new Node(-1, null, _head, null);
        dfs(pre, _head);
        pre.next.prev = null;
        return pre.next;
    }

    static Node dfs(Node _prev, Node _curr) {
        if (_curr == null) {
            return _prev;
        }
        _curr.prev = _prev;
        _prev.next = _curr;

        Node next = _curr.next;
        Node tail = dfs(_curr, _curr.child);
        _curr.child = null;
        return dfs(tail, next);
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class Node {
        final int val;
        Node      prev;
        Node      next;
        Node      child;

        Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

}
