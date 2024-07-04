package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0776 extends LeetcodeProblem {

    TreeNode[] splitBST(TreeNode _root, int _v) {
        TreeNode small = new TreeNode(0);
        TreeNode big = new TreeNode(0);
        split(_root, _v, small, big);
        return new TreeNode[] {small.right, big.left};
    }

    private void split(TreeNode _root, int _v, TreeNode _small, TreeNode _big) {
        if (_root == null) {
            return;
        }
        if (_root.val <= _v) {
            _small.right = _root;
            TreeNode right = _root.right;
            _root.right = null;
            split(right, _v, _root, _big);
        } else {
            _big.left = _root;
            TreeNode left = _root.left;
            _root.left = null;
            split(left, _v, _small, _root);
        }
    }

}
