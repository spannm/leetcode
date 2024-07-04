package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 968. Binary Tree Cameras.
 */
class Problem0968 extends LeetcodeProblem {

    int minCameraCover(TreeNode _root) {
        int[] ans = dfs(_root);
        return Math.min(ans[0], ans[1]);
    }

    static int[] dfs(TreeNode _root) {
        if (_root == null) {
            return new int[] {1 << 29, 0, 0};
        }
        var l = dfs(_root.left);
        var r = dfs(_root.right);
        int a = 1 + Math.min(Math.min(l[0], l[1]), l[2]) + Math.min(Math.min(r[0], r[1]), r[2]);
        int b = Math.min(Math.min(l[0] + r[1], l[1] + r[0]), l[0] + r[0]);
        int c = l[1] + r[1];
        return new int[] {a, b, c};
    }

}
