package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2800. Shortest String That Contains Three Strings.
 */
class Problem2800 extends LeetcodeProblem {

    String minimumString(String a, String b, String c) {
        String[] s = {a, b, c};
        int[][] perm = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 1, 0}, {2, 0, 1}};
        String ans = "";
        for (var p : perm) {
            int i = p[0];
            int j = p[1];
            int k = p[2];
            String t = f(f(s[i], s[j]), s[k]);
            if (ans.isEmpty() || t.length() < ans.length()
                || t.length() == ans.length() && t.compareTo(ans) < 0) {
                ans = t;
            }
        }
        return ans;
    }

    private String f(String s, String t) {
        if (s.contains(t)) {
            return s;
        }
        if (t.contains(s)) {
            return t;
        }
        int m = s.length();
        int n = t.length();
        for (int i = Math.min(m, n); i > 0; i--) {
            if (s.substring(m - i).equals(t.substring(0, i))) {
                return s + t.substring(i);
            }
        }
        return s + t;
    }

}
