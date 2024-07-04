package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0623 extends LeetcodeProblem {

    TreeNode addOneRow(TreeNode _root, int _v, int _d) {
        if (_d == 1) {
            TreeNode newRoot = new TreeNode(_v);
            newRoot.left = _root;
            return newRoot;
        }
        return dfs(_root, _v, _d);
    }

    static TreeNode dfs(TreeNode _root, int _v, int _d) {
        if (_root != null) {
            if (_d == 2) {
                TreeNode newLeft = new TreeNode(_v);
                TreeNode newRight = new TreeNode(_v);
                newLeft.left = _root.left;
                newRight.right = _root.right;
                _root.left = newLeft;
                _root.right = newRight;
            } else {
                dfs(_root.left, _v, _d - 1);
                dfs(_root.right, _v, _d - 1);
            }
        }
        return _root;
    }

}
