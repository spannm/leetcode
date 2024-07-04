package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0404 extends LeetcodeProblem {

    int sumOfLeftLeaves(TreeNode _root) {
        return _root == null ? 0 : dfs(_root, 0, false);
    }

    static int dfs(TreeNode _root, int _result, boolean _left) {
        if (_root.left == null && _root.right == null && _left) {
            _result += _root.val;
            return _result;
        }
        int leftResult = 0;
        if (_root.left != null) {
            leftResult = dfs(_root.left, _result, true);
        }
        int rightResult = 0;
        if (_root.right != null) {
            rightResult = dfs(_root.right, _result, false);
        }
        return leftResult + rightResult;
    }

}
