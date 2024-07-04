package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree/">110. Balanced Binary Tree</a>.
 */
class Problem0110 extends LeetcodeProblem {

    boolean isBalanced(TreeNode _root) {
        if (_root == null) {
            return true;
        } else if (Math.abs(getHeight(_root.left) - getHeight(_root.right)) > 1) {
            return false;
        } else {
            return isBalanced(_root.left) && isBalanced(_root.right);
        }
    }

    private static int getHeight(TreeNode _root) {
        if (_root == null) {
            return 0;
        }
        int leftH = getHeight(_root.left);
        int rightH = getHeight(_root.right);
        return Math.max(leftH, rightH) + 1;
    }

}
