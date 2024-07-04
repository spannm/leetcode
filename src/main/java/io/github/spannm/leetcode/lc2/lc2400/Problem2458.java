package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2458. Height of Binary Tree After Subtree Removal Queries.
 */
class Problem2458 extends LeetcodeProblem {

    private final Map<TreeNode, Integer> d = new HashMap<>();
    private int[]                        res;

    int[] treeQueries(TreeNode root, int[] queries) {
        f(root);
        res = new int[d.size() + 1];
        d.put(null, 0);
        dfs(root, -1, 0);
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = res[queries[i]];
        }
        return ans;
    }

    private void dfs(TreeNode root, int depth, int rest) {
        if (root == null) {
            return;
        }
        depth++;
        res[root.val] = rest;
        dfs(root.left, depth, Math.max(rest, depth + d.get(root.right)));
        dfs(root.right, depth, Math.max(rest, depth + d.get(root.left)));
    }

    private int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = f(root.left);
        int r = f(root.right);
        d.put(root, 1 + Math.max(l, r));
        return d.get(root);
    }

}
