package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">117. Populating Next Right
 * Pointers in Each Node II</a>.
 */
class Problem0117 extends LeetcodeProblem {

    Node connect(Node _root) {
        Node head = null;
        Node prev = null;
        Node cur = _root;

        while (cur != null) {

            while (cur != null) {

                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }

                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }

                cur = cur.next;
            }

            cur = head;
            head = null;
            prev = null;
        }
        return _root;
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class Node {
        final int val;
        Node      left;
        Node      right;
        Node      next;

        Node(int _x) {
            val = _x;
        }
    }

}
