package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2673. Make Costs of Paths Equal in a Binary Tree.
 */
class Problem2673 extends LeetcodeProblem {

    private int[] cost;
    private int   n;
    private int   ans;

    int minIncrements(int _n, int[] _cost) {
        n = _n;
        cost = _cost;
        dfs(1);
        return ans;
    }

    int dfs(int i) {
        if (i << 1 > n) {
            return cost[i - 1];
        }
        int l = dfs(i << 1);
        int r = dfs(i << 1 | 1);
        ans += Math.max(l, r) - Math.min(l, r);
        return cost[i - 1] + Math.max(l, r);
    }

}
