package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0965 extends LeetcodeProblem {

    boolean isUnivalTree(TreeNode _root) {
        return _root == null || dfs(_root, _root.val);
    }

    private static boolean dfs(TreeNode _root, int _value) {
        if (_root == null) {
            return true;
        } else if (_root.val != _value) {
            return false;
        }
        return dfs(_root.left, _value) && dfs(_root.right, _value);
    }

}
