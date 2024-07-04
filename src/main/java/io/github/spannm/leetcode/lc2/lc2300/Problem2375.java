package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2375. Construct Smallest Number From DI String.
 */
class Problem2375 extends LeetcodeProblem {

    private final boolean[]     vis = new boolean[10];
    private final StringBuilder t   = new StringBuilder();
    private String              p;
    private String              ans;

    String smallestNumber(String pattern) {
        p = pattern;
        dfs(0);
        return ans;
    }

    private void dfs(int u) {
        if (ans != null) {
            return;
        }
        if (u == p.length() + 1) {
            ans = t.toString();
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!vis[i]) {
                if (u > 0 && p.charAt(u - 1) == 'I' && t.charAt(u - 1) - '0' >= i) {
                    continue;
                }
                if (u > 0 && p.charAt(u - 1) == 'D' && t.charAt(u - 1) - '0' <= i) {
                    continue;
                }
                vis[i] = true;
                t.append(i);
                dfs(u + 1);
                t.deleteCharAt(t.length() - 1);
                vis[i] = false;
            }
        }
    }

}
