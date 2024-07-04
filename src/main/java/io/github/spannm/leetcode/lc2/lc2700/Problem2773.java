package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 2773. Height of Special Binary Tree.
 */
class Problem2773 extends LeetcodeProblem {

    private int ans;

    int heightOfTree(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int d) {
        ans = Math.max(ans, d++);
        if (root.left != null && root.left.right != root) {
            dfs(root.left, d);
        }
        if (root.right != null && root.right.left != root) {
            dfs(root.right, d);
        }
    }

}
