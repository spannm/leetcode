package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2746. Decremental String Concatenation.
 */
class Problem2746 extends LeetcodeProblem {

    private String[]      words;
    private int           n;
    private Integer[][][] f;

    int minimizeConcatenatedLength(String[] _words) {
        words = _words;
        n = _words.length;
        f = new Integer[n][26][26];
        return _words[0].length()
            + dfs(1, _words[0].charAt(0) - 'a', _words[0].charAt(_words[0].length() - 1) - 'a');
    }

    private int dfs(int i, int a, int b) {
        if (i >= n) {
            return 0;
        }
        if (f[i][a][b] != null) {
            return f[i][a][b];
        }
        String s = words[i];
        int m = s.length();
        int x = dfs(i + 1, a, s.charAt(m - 1) - 'a') - (s.charAt(0) - 'a' == b ? 1 : 0);
        int y = dfs(i + 1, s.charAt(0) - 'a', b) - (s.charAt(m - 1) - 'a' == a ? 1 : 0);
        return f[i][a][b] = m + Math.min(x, y);
    }

}
