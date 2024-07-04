package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0701 extends LeetcodeProblem {

    TreeNode insertIntoBST(TreeNode _root, int _val) {
        if (_root == null) {
            return new TreeNode(_val);
        } else if (_root.val < _val) {
            _root.right = insertIntoBST(_root.right, _val);
        } else {
            _root.left = insertIntoBST(_root.left, _val);
        }
        return _root;
    }

}
