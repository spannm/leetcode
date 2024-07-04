package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0235 extends LeetcodeProblem {

    TreeNode lowestCommonAncestor(TreeNode _root, TreeNode _p, TreeNode _q) {
        if (_root == null || _p == _root || _q == _root) {
            return _root;
        } else if (_root.val > _p.val && _root.val > _q.val) {
            return lowestCommonAncestor(_root.left, _p, _q);
        } else if (_root.val < _p.val && _root.val < _q.val) {
            return lowestCommonAncestor(_root.right, _p, _q);
        }
        return _root;
    }

}
