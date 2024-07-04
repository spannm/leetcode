package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">116. Populating Next Right
 * Pointers in Each Node</a>.
 */
class Problem0116 extends LeetcodeProblem {

    Node connect(Node _root) {
        if (_root == null) {
            return null;
        } else if (_root.left != null) {
            _root.left.next = _root.right;
        }
        if (_root.right != null && _root.next != null) {
            _root.right.next = _root.next.left;
        }
        connect(_root.left);
        connect(_root.right);
        return _root;
    }

    static class Node {
        private int  val;
        private Node left;
        private Node right;
        private Node next;

        Node() {
        }

        Node(int _val) {
            val = _val;
        }

        Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        int getVal() {
            return val;
        }

    }

}
