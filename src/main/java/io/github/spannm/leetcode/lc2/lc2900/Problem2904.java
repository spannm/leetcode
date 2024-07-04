package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2904. Shortest and Lexicographically Smallest Beautiful String.
 */
class Problem2904 extends LeetcodeProblem {

    String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int j = 0;
        int cnt = 0;
        int n = s.length();
        String ans = "";
        while (j < n) {
            cnt += s.charAt(j) - '0';
            while (cnt > k || i < j && s.charAt(i) == '0') {
                cnt -= s.charAt(i) - '0';
                i++;
            }
            j++;
            String t = s.substring(i, j);
            if (cnt == k
                && (ans.isEmpty() || j - i < ans.length()
                    || j - i == ans.length() && t.compareTo(ans) < 0)) {
                ans = t;
            }
        }
        return ans;
    }

}
