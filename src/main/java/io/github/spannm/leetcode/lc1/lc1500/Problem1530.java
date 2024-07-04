package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 1530. Number of Good Leaf Nodes Pairs.
 */
class Problem1530 extends LeetcodeProblem {

    int countPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }
        int ans = countPairs(root.left, distance) + countPairs(root.right, distance);
        int[] cnt1 = new int[distance];
        int[] cnt2 = new int[distance];
        dfs(root.left, cnt1, 1);
        dfs(root.right, cnt2, 1);
        for (int i = 0; i < distance; i++) {
            for (int j = 0; j < distance; j++) {
                if (i + j <= distance) {
                    ans += cnt1[i] * cnt2[j];
                }
            }
        }
        return ans;
    }

    void dfs(TreeNode root, int[] cnt, int i) {
        if (root == null || i >= cnt.length) {
            return;
        }
        if (root.left == null && root.right == null) {
            cnt[i]++;
            return;
        }
        dfs(root.left, cnt, i + 1);
        dfs(root.right, cnt, i + 1);
    }

}
