package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 2331. Evaluate Boolean Binary Tree.
 */
class Problem2331 extends LeetcodeProblem {

    boolean evaluateTree(TreeNode _root) {
        if (_root == null) {
            return true;
        } else if (_root.left == null && _root.right == null) {
            return _root.val != 0;
        } else if (_root.val == 2) {
            return evaluateTree(_root.left) || evaluateTree(_root.right);
        } else {
            return evaluateTree(_root.left) && evaluateTree(_root.right);
        }
    }

}
