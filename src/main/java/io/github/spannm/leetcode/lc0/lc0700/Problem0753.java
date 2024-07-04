package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 753. Cracking the Safe.
 */
class Problem0753 extends LeetcodeProblem {

    private final Set<Integer>  vis = new HashSet<>();
    private final StringBuilder ans = new StringBuilder();
    private int                 mod;

    String crackSafe(int _n, int _k) {
        mod = (int) Math.pow(10, _n - 1);
        dfs(0, _k);
        ans.append("0".repeat(_n - 1));
        return ans.toString();
    }

    private void dfs(int _u, int _k) {
        for (int x = 0; x < _k; x++) {
            int e = _u * 10 + x;
            if (vis.add(e)) {
                int v = e % mod;
                dfs(v, _k);
                ans.append(x);
            }
        }
    }

}
