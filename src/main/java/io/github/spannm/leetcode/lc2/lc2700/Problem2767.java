package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2767. Partition String Into Minimum Beautiful Substrings.
 */
class Problem2767 extends LeetcodeProblem {

    private Integer[]       f;
    private String          s;
    private final Set<Long> ss = new HashSet<>();
    private int             n;

    int minimumBeautifulSubstrings(String _s) {
        s = _s;
        n = _s.length();
        f = new Integer[n];
        long x = 1;
        for (int i = 0; i <= n; i++) {
            ss.add(x);
            x *= 5;
        }
        int ans = dfs(0);
        return ans > n ? -1 : ans;
    }

    int dfs(int i) {
        if (i >= n) {
            return 0;
        } else if (s.charAt(i) == '0') {
            return n + 1;
        } else if (f[i] != null) {
            return f[i];
        }
        long x = 0;
        int ans = n + 1;
        for (int j = i; j < n; j++) {
            x = x << 1 | s.charAt(j) - '0';
            if (ss.contains(x)) {
                ans = Math.min(ans, 1 + dfs(j + 1));
            }
        }
        return f[i] = ans;
    }

}
