package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 337. House Robber III.
 */
class Problem0337 extends LeetcodeProblem {

    int rob(TreeNode _root) {
        int[] ans = dfs(_root);
        return Math.max(ans[0], ans[1]);
    }

    static int[] dfs(TreeNode _root) {
        if (_root == null) {
            return new int[2];
        }
        int[] l = dfs(_root.left);
        int[] r = dfs(_root.right);
        return new int[] {_root.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])};
    }

}
