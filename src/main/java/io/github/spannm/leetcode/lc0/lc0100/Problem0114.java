package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">114. Flatten Binary Tree to Linked
 * List</a>.
 */
class Problem0114 extends LeetcodeProblem {

    void flatten(TreeNode _root) {
        while (_root != null) {
            if (_root.left != null) {
                TreeNode prevNode = _root.left;
                while (prevNode.right != null) {
                    prevNode = prevNode.right;
                }
                prevNode.right = _root.right;
                _root.right = _root.left;
                _root.left = null;
            }
            _root = _root.right;
        }
    }

}
