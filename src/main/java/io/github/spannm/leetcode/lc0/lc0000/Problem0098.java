package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0098 extends LeetcodeProblem {

    boolean isValidBST(TreeNode _root) {
        return isValid(_root, null, null);
    }

    static boolean isValid(TreeNode _root, Integer _min, Integer _max) {
        if (_root == null) {
            return true;
        } else if (_min != null && _root.val <= _min || _max != null && _root.val >= _max) {
            return false;
        }
        return isValid(_root.left, _min, _root.val)
            && isValid(_root.right, _root.val, _max);
    }

}
