package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/delete-leaves-with-a-given-value/">1325. Delete Leaves With a Given Value</a>.
 */
class Problem1325 extends LeetcodeProblem {

    TreeNode removeLeafNodes(TreeNode _root, int _target) {
        while (hasLeafWithValue(_root, _target)) {
            _root = deleteLeafWithValue(_target, _root);
        }
        return _root;
    }

    static TreeNode deleteLeafWithValue(int _target, TreeNode _root) {
        if (_root.val == _target && _root.left == null && _root.right == null) {
            return null;
        }
        if (_root.left != null) {
            if (_root.left.val == _target && _root.left.left == null && _root.left.right == null) {
                _root.left = null;
            } else {
                deleteLeafWithValue(_target, _root.left);
            }
        }
        if (_root.right != null) {
            if (_root.right.val == _target && _root.right.left == null && _root.right.right == null) {
                _root.right = null;
            } else {
                deleteLeafWithValue(_target, _root.right);
            }
        }

        return _root;
    }

    static boolean hasLeafWithValue(TreeNode _root, int _val) {
        if (_root == null) {
            return false;
        } else if (_root.left == null && _root.right == null && _root.val == _val) {
            return true;
        }
        return hasLeafWithValue(_root.left, _val) || hasLeafWithValue(_root.right, _val);
    }

}
