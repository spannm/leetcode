package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 510. Inorder Successor in BST II.
 */
class Problem0510 extends LeetcodeProblem {

    Node inorderSuccessor(Node _node) {
        if (_node.right != null) {
            _node = _node.right;
            while (_node.left != null) {
                _node = _node.left;
            }
            return _node;
        }
        while (_node.parent != null && _node == _node.parent.right) {
            _node = _node.parent;
        }
        return _node.parent;
    }

    static class Node {
        private Node left;
        private Node right;
        private Node parent;
    }

}
