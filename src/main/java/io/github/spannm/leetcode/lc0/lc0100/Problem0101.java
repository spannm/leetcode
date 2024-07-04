package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/">101. Symmetric Tree</a>.
 */
class Problem0101 extends LeetcodeProblem {

    boolean isSymmetric(TreeNode _root) {
        return isSymmetric(_root.left, _root.right);
    }

    static boolean isSymmetric(TreeNode _left, TreeNode _right) {
        if (_left == _right) {
            return true;
        } else if (_left == null || _right == null) {
            return false;
        }
        return Objects.equals(_left.val, _right.val)
            && isSymmetric(_left.left, _right.right)
            && isSymmetric(_left.right, _right.left);
    }

}
