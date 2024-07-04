package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/">530. Minimum Absolute
 * Difference in BST</a>.
 */
class Problem0530 extends LeetcodeProblem {

    private int     min  = Integer.MAX_VALUE;
    private Integer prev = null;

    int getMinimumDifference(TreeNode _node) {
        if (_node == null) {
            return min;
        }

        getMinimumDifference(_node.left);

        if (prev != null) {
            min = Math.min(min, _node.val - prev);
        }
        prev = _node.val;

        getMinimumDifference(_node.right);

        return min;
    }

    int getMinimumDifference2(TreeNode _root) {
        return inorderTraversal(_root, Integer.MAX_VALUE);
    }

    int inorderTraversal(final TreeNode _node, int _minDiff) {
        if (_node == null) {
            return _minDiff;
        } else if (_node.left != null) {
            _minDiff = Math.min(_minDiff, Math.abs(_node.val - _node.left.val));
            _minDiff = Math.min(_minDiff, inorderTraversal(_node.left, _minDiff));
        }
        if (_node.right != null) {
            _minDiff = Math.min(_minDiff, Math.abs(_node.val - _node.right.val));
            _minDiff = Math.min(_minDiff, inorderTraversal(_node.right, _minDiff));
        }
        return _minDiff;
    }

}
