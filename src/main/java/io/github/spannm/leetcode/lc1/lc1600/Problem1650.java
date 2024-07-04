package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1650 extends LeetcodeProblem {

    Node lowestCommonAncestor(Node _p, Node _q) {
        Node a = _p;
        Node b = _q;
        while (a != b) {
            a = a == null ? _p : a.parent;
            b = b == null ? _q : b.parent;
        }
        return a;
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class Node {
        public final int val;
        public Node      parent;
        public Node      left;
        public Node      right;

        Node(int _val) {
            val = _val;
        }
    }

}
