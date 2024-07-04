package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1849. Splitting a String Into Descending Consecutive Values.
 */
class Problem1849 extends LeetcodeProblem {

    private String s;

    boolean splitString(String _s) {
        s = _s;
        return dfs(0, -1, 0);
    }

    private boolean dfs(int i, long x, int k) {
        if (i == s.length()) {
            return k > 1;
        }
        long y = 0;
        for (int j = i; j < s.length(); j++) {
            y = y * 10 + (s.charAt(j) - '0');
            if ((x == -1 || x - y == 1) && dfs(j + 1, y, k + 1)) {
                return true;
            }
        }
        return false;
    }

}
