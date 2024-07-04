package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2003. Smallest Missing Genetic Value in Each Subtree.
 */
class Problem2003 extends LeetcodeProblem {

    private List<Integer>[] g;
    private boolean[]       vis;
    private boolean[]       has;
    private int[]           nums;

    int[] smallestMissingValueSubtree(int[] _parents, int[] _nums) {
        int len = _nums.length;
        nums = _nums;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[len];
        g = lists;
        vis = new boolean[len];
        has = new boolean[len + 2];
        Arrays.setAll(g, i -> new ArrayList<>());
        int idx = -1;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                g[_parents[i]].add(i);
            }
            if (_nums[i] == 1) {
                idx = i;
            }
        }
        int[] ans = new int[len];
        Arrays.fill(ans, 1);
        if (idx == -1) {
            return ans;
        }
        for (int i = 2; idx != -1; idx = _parents[idx]) {
            dfs(idx);
            while (has[i]) {
                i++;
            }
            ans[idx] = i;
        }
        return ans;
    }

    private void dfs(int i) {
        if (vis[i]) {
            return;
        }
        vis[i] = true;
        if (nums[i] < has.length) {
            has[nums[i]] = true;
        }
        for (int j : g[i]) {
            dfs(j);
        }
    }

}
