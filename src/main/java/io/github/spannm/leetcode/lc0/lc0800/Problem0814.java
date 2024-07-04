package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0814 extends LeetcodeProblem {

    TreeNode pruneTree(TreeNode _root) {
        if (_root == null) {
            return null;
        }
        _root.left = pruneTree(_root.left);
        _root.right = pruneTree(_root.right);
        if (_root.left == null && _root.right == null && _root.val == 0) {
            return null;
        }
        return _root;
    }

}
