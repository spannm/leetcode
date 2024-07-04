package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 943. Find the Shortest Superstring.
 */
class Problem0943 extends LeetcodeProblem {

    String shortestSuperstring(String[] _words) {
        int len = _words.length;
        int[][] g = new int[len][len];
        for (int i = 0; i < len; i++) {
            String a = _words[i];
            for (int j = 0; j < len; j++) {
                String b = _words[j];
                if (i != j) {
                    for (int k = Math.min(a.length(), b.length()); k > 0; k--) {
                        if (a.substring(a.length() - k).equals(b.substring(0, k))) {
                            g[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }
        int[][] dp = new int[1 << len][len];
        int[][] p = new int[1 << len][len];
        for (int i = 0; i < 1 << len; i++) {
            Arrays.fill(p[i], -1);
            for (int j = 0; j < len; j++) {
                if ((i >> j & 1) == 1) {
                    int pi = i ^ 1 << j;
                    for (int k = 0; k < len; k++) {
                        if ((pi >> k & 1) == 1) {
                            int v = dp[pi][k] + g[k][j];
                            if (v > dp[i][j]) {
                                dp[i][j] = v;
                                p[i][j] = k;
                            }
                        }
                    }
                }
            }
        }
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (dp[(1 << len) - 1][i] > dp[(1 << len) - 1][j]) {
                j = i;
            }
        }
        List<Integer> arr = new ArrayList<>();
        arr.add(j);
        for (int i = (1 << len) - 1; p[i][j] != -1;) {
            int k = i;
            i ^= 1 << j;
            j = p[k][j];
            arr.add(j);
        }
        Set<Integer> vis = new HashSet<>(arr);
        for (int i = 0; i < len; i++) {
            if (!vis.contains(i)) {
                arr.add(i);
            }
        }
        Collections.reverse(arr);
        StringBuilder ans = new StringBuilder(_words[arr.get(0)]);
        for (int i = 1; i < len; i++) {
            int k = g[arr.get(i - 1)][arr.get(i)];
            ans.append(_words[arr.get(i)].substring(k));
        }
        return ans.toString();
    }

}
