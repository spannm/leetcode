package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0471 extends LeetcodeProblem {

    String encode(String _s) {
        String[][] dp = new String[_s.length()][_s.length()];

        for (int l = 0; l < _s.length(); l++) {
            for (int i = 0; i < _s.length() - l; i++) {
                int j = i + l;
                String substr = _s.substring(i, j + 1);

                if (j - i < 4) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;

                    for (int k = i; k < j; k++) {
                        if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }

                    for (int k = 0; k < substr.length(); k++) {
                        String repeatStr = substr.substring(0, k + 1);
                        if (substr.length() % repeatStr.length() == 0 && substr.replaceAll(repeatStr, "").isEmpty()) {
                            String ss = substr.length() / repeatStr.length() + "[" + dp[i][i + k] + "]";
                            if (ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][_s.length() - 1];
    }

}
