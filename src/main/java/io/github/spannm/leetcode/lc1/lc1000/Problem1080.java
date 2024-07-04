package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 1080. Insufficient Nodes in Root to Leaf Paths.
 */
class Problem1080 extends LeetcodeProblem {

    TreeNode sufficientSubset(TreeNode _root, int _limit) {
        if (_root == null) {
            return null;
        }
        _limit -= _root.val;
        if (_root.left == null && _root.right == null) {
            return _limit > 0 ? null : _root;
        }
        _root.left = sufficientSubset(_root.left, _limit);
        _root.right = sufficientSubset(_root.right, _limit);
        return _root.left == null && _root.right == null ? null : _root;
    }

}
