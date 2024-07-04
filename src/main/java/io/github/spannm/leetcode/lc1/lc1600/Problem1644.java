package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1644 extends LeetcodeProblem {

    static TreeNode lowestCommonAncestor(TreeNode _root, TreeNode _p, TreeNode _q) {
        boolean[] exists = new boolean[2];
        exists(_p, _root, 0, exists);
        exists(_q, _root, 1, exists);
        if (!exists[0] || !exists[1]) {
            return null;
        }
        return dfs(_root, _p, _q);
    }

    static void exists(TreeNode _target, TreeNode _root, int _index, boolean[] _exists) {
        if (_root != null) {
            if (_target == _root) {
                _exists[_index] = true;
            } else if (!_exists[_index]) {
                exists(_target, _root.left, _index, _exists);
            }
        }
    }

    static TreeNode dfs(TreeNode _root, TreeNode _p, TreeNode _q) {
        if (_root == null || _p == _root || _q == _root) {
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
