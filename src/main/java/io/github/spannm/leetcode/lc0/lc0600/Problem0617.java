package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/merge-two-binary-trees/">617. Merge Two Binary Trees</a>.
 */
class Problem0617 extends LeetcodeProblem {

    TreeNode mergeTrees(TreeNode _root1, TreeNode _root2) {
        if (_root1 == null) {
            return _root2;
        } else if (_root2 == null) {
            return _root1;
        }
        _root1.val += _root2.val;
        _root1.left = mergeTrees(_root1.left, _root2.left);
        _root1.right = mergeTrees(_root1.right, _root2.right);
        return _root1;
    }

}
