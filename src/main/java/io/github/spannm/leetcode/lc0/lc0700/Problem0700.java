package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0700 extends LeetcodeProblem {

    TreeNode searchBST(TreeNode _root, int _val) {
        if (_root == null) {
            return null;
        } else if (_root.val == _val) {
            return _root;
        } else if (_root.val > _val) {
            return searchBST(_root.left, _val);
        } else {
            return searchBST(_root.right, _val);
        }
    }

}
