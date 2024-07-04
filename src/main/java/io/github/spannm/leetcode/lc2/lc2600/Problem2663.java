package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2663. Lexicographically Smallest Beautiful String.
 */
class Problem2663 extends LeetcodeProblem {

    @SuppressWarnings("PMD.AvoidBranchingStatementAsLastInLoop")
    String smallestBeautifulString(String _s, int _k) {
        int n = _s.length();
        char[] cs = _s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            int p = cs[i] - 'a' + 1;
            for (int j = p; j < _k; j++) {
                char c = (char) ('a' + j);
                if (i > 0 && cs[i - 1] == c || i > 1 && cs[i - 2] == c) {
                    continue;
                }
                cs[i] = c;
                for (int l = i + 1; l < n; l++) {
                    for (int m = 0; m < _k; m++) {
                        c = (char) ('a' + m);
                        if (l > 0 && cs[l - 1] == c || l > 1 && cs[l - 2] == c) {
                            continue;
                        }
                        cs[l] = c;
                        break;
                    }
                }
                return String.valueOf(cs);
            }
        }
        return "";
    }

}
