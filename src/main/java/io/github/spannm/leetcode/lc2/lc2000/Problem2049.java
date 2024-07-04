package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2049. Count Nodes With the Highest Score.
 */
class Problem2049 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int             ans;
    private long            mx;
    private int             n;

    int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parents[i]].add(i);
        }
        dfs(0, -1);
        return ans;
    }

    private int dfs(int i, int fa) {
        int cnt = 1;
        long score = 1;
        for (int j : g[i]) {
            if (j != fa) {
                int t = dfs(j, i);
                cnt += t;
                score *= t;
            }
        }
        if (n - cnt > 0) {
            score *= n - cnt;
        }
        if (mx < score) {
            mx = score;
            ans = 1;
        } else if (mx == score) {
            ans++;
        }
        return cnt;
    }

}
