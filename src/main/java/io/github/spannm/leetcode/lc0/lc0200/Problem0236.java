package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0236 extends LeetcodeProblem {

    TreeNode lowestCommonAncestor(TreeNode _root, TreeNode _p, TreeNode _q) {
        if (_root == null || _root == _p || _root == _q) {
            return _root;
        }
        TreeNode left = lowestCommonAncestor(_root.left, _p, _q);
        TreeNode right = lowestCommonAncestor(_root.right, _p, _q);
        if (left != null && right != null) {
            return _root;
        }
        return left != null ? left : right;
    }

}
