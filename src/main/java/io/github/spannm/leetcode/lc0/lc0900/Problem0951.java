package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0951 extends LeetcodeProblem {

    boolean flipEquiv(TreeNode _root1, TreeNode _root2) {
        if (_root1 == null && _root2 == null) {
            return true;
        } else if (_root1 == null || _root2 == null || _root1.val != _root2.val) {
            return false;
        }

        return flipEquiv(_root1.left, _root2.left) && flipEquiv(_root1.right, _root2.right)
            || flipEquiv(_root1.left, _root2.right) && flipEquiv(_root1.right, _root2.left);
    }

}
