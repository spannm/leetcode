package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 1593. Split a String Into the Max Number of Unique Substrings.
 */
class Problem1593 extends LeetcodeProblem {

    private final Set<String> vis = new HashSet<>();
    private int               ans = 1;
    private String            s;

    int maxUniqueSplit(String _s) {
        s = _s;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int t) {
        if (i >= s.length()) {
            ans = Math.max(ans, t);
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            String x = s.substring(i, j);
            if (vis.add(x)) {
                dfs(j, t + 1);
                vis.remove(x);
            }
        }
    }

}
