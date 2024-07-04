package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0669 extends LeetcodeProblem {

    TreeNode trimBST(TreeNode _root, int _l, int _r) {
        if (_root == null) {
            return null;
        } else if (_root.val > _r) {
            return trimBST(_root.left, _l, _r);
        } else if (_root.val < _l) {
            return trimBST(_root.right, _l, _r);
        }

        _root.left = trimBST(_root.left, _l, _r);
        _root.right = trimBST(_root.right, _l, _r);
        return _root;
    }

}
