package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 1740. Find Distance in a Binary Tree.
 */
class Problem1740 extends LeetcodeProblem {

    int findDistance(TreeNode root, int p, int q) {
        TreeNode g = lca(root, p, q);
        return dfs(g, p) + dfs(g, q);
    }

    private int dfs(TreeNode root, int v) {
        if (root == null) {
            return -1;
        }
        if (root.val == v) {
            return 0;
        }
        int left = dfs(root.left, v);
        int right = dfs(root.right, v);
        if (left == -1 && right == -1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}
