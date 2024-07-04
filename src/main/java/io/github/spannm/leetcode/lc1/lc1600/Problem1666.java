package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1666. Change the Root of a Binary Tree.
 */
class Problem1666 extends LeetcodeProblem {

    Node flipBinaryTree(Node _root, Node _leaf) {
        Node curr = _leaf;
        Node p = curr.parent;
        while (curr != _root) {
            if (curr.left != null) {
                curr.right = curr.left;
            }
            curr.left = p;
            Node gp = p.parent;
            p.parent = curr;
            if (p.left == curr) {
                p.left = null;
            } else if (p.right == curr) {
                p.right = null;
            }
            curr = p;
            p = gp;
        }
        _leaf.parent = null;
        return _leaf;
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class Node {
        int  val;
        Node left;
        Node right;
        Node parent;
    }

}
