package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 2313. Minimum Flips in Binary Tree to Get Result.
 */
class Problem2313 extends LeetcodeProblem {

    int minimumFlips(TreeNode root, boolean result) {
        return dfs(root)[result ? 1 : 0];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {1 << 30, 1 << 30};
        }
        int x = root.val;
        if (x < 2) {
            return new int[] {x, x ^ 1};
        }
        var l = dfs(root.left);
        var r = dfs(root.right);
        int a = 0;
        int b = 0;
        if (x == 2) {
            a = l[0] + r[0];
            b = Math.min(l[0] + r[1], Math.min(l[1] + r[0], l[1] + r[1]));
        } else if (x == 3) {
            a = Math.min(l[0] + r[0], Math.min(l[0] + r[1], l[1] + r[0]));
            b = l[1] + r[1];
        } else if (x == 4) {
            a = Math.min(l[0] + r[0], l[1] + r[1]);
            b = Math.min(l[0] + r[1], l[1] + r[0]);
        } else {
            a = Math.min(l[1], r[1]);
            b = Math.min(l[0], r[0]);
        }
        return new int[] {a, b};
    }

}
