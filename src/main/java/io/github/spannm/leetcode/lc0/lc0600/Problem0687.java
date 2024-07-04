package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0687 extends LeetcodeProblem {

    int longestUnivaluePath(TreeNode _root) {
        int[] result = new int[1];
        if (_root != null) {
            dfs(_root, result);
        }
        return result[0];
    }

    private static int dfs(TreeNode _root, int[] _result) {
        int leftPath = _root.left == null ? 0 : dfs(_root.left, _result);
        int rightPath = _root.right == null ? 0 : dfs(_root.right, _result);
        int leftResult = _root.left != null && _root.left.val == _root.val ? leftPath + 1 : 0;
        int rightResult = _root.right != null && _root.right.val == _root.val ? rightPath + 1 : 0;
        _result[0] = Math.max(_result[0], leftResult + rightResult);
        return Math.max(leftResult, rightResult);
    }

}
