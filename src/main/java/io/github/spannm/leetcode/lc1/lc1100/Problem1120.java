package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 1120. Maximum Average Subtree.
 */
class Problem1120 extends LeetcodeProblem {

    private double ans;

    double maximumAverageSubtree(TreeNode _root) {
        dfs(_root);
        return ans;
    }

    private int[] dfs(TreeNode _root) {
        if (_root == null) {
            return new int[2];
        }
        int[] l = dfs(_root.left);
        int[] r = dfs(_root.right);
        int s = _root.val + l[0] + r[0];
        int n = 1 + l[1] + r[1];
        ans = Math.max(ans, s * 1.0 / n);
        return new int[] {s, n};
    }

}
