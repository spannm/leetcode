package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2445. Number of Nodes With Value One.
 */
class Problem2445 extends LeetcodeProblem {

    private int[] tree;

    int numberOfNodes(int n, int[] queries) {
        tree = new int[n + 1];
        int[] cnt = new int[n + 1];
        for (int v : queries) {
            cnt[v]++;
        }
        for (int i = 0; i < n + 1; i++) {
            if (cnt[i] % 2 == 1) {
                dfs(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans += tree[i];
        }
        return ans;
    }

    private void dfs(int i) {
        if (i >= tree.length) {
            return;
        }
        tree[i] ^= 1;
        dfs(i << 1);
        dfs(i << 1 | 1);
    }

}
