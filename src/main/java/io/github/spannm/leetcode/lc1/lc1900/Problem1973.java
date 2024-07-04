package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 1973. Count Nodes Equal to Sum of Descendants.
 */
class Problem1973 extends LeetcodeProblem {

    private int ans;

    int equalToDescendants(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l + r == root.val) {
            ans++;
        }
        return root.val + l + r;
    }

}
