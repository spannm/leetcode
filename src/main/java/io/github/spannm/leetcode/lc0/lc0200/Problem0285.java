package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0285 extends LeetcodeProblem {

    TreeNode inorderSuccessor(TreeNode _root, TreeNode _p) {
        TreeNode successor = null;
        while (_root != null) {
            if (_p.val < _root.val) {
                successor = _root;
                _root = _root.left;
            } else {
                _root = _root.right;
            }
        }
        return successor;
    }

}
