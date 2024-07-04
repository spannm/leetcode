package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/path-sum/">112. Path Sum</a>.
 */
class Problem0112 extends LeetcodeProblem {

    boolean hasPathSum(TreeNode _root, int _sum) {
        if (_root == null) {
            return false;
        } else if (_root.val == _sum && _root.left == null && _root.right == null) {
            return true;
        }
        return hasPathSum(_root.left, _sum - _root.val)
            || hasPathSum(_root.right, _sum - _root.val);
    }

}
