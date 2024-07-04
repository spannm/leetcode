package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1531. String Compression II
 */
class Problem1531 extends LeetcodeProblem {

    int getLengthOfOptimalCompression(String _s, int _k) {
        int len = _s.length();
        if (len <= 1) {
            if (len == 0) {
                return 0;
            }
            return _k > 0 ? 0 : 1;
        } else if (_k == 0) {
            return compress(_s);
        }

        int[][] dp = new int[len + 1][_k + 1];

        for (int i = len; i >= 0; i--) {
            for (int j = 0; j <= _k; j++) {
                // Base case - initial length declaration
                if (i == len) {
                    dp[len][j] = 0;
                    continue;
                }

                // Case 1 - delete the ith character if possible (j > 0)
                dp[i][j] = j > 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE;

                // Case 2 - we keep the ith index.
                // We have to find the current char's index endpoint
                int count = 0;
                int ok2Del = j;
                for (int end = i; end < len && ok2Del >= 0; end++) {
                    // Check about the same char "b b b .." for encoding
                    if (_s.charAt(end) == _s.charAt(i)) {
                        count++;

                        // Assuming the block ends here "aaaa"
                        dp[i][j] = Math.min(dp[i][j], calcLen(count) + dp[end + 1][ok2Del]);
                    } else {
                        // This character should be deleted to make the length min
                        ok2Del--;
                    }
                }
            }
        }

        return dp[0][_k];
    }

    static int calcLen(int _count) {
        if (_count == 1) {
            return 1;
        } else if (_count < 10) {
            return 2;
        } else if (_count < 100) {
            return 3;
        }
        return 4;
    }

    static int compress(String _s) {
        int len = _s.length();
        int k = 0; // out index
        for (int i = 0, j = i + 1; i < len;) {
            while (j < len && _s.charAt(j) == _s.charAt(i)) {
                j++;
            }
            k++;
            if (j - i > 1) {
                String count = String.valueOf(j - i);
                k += count.length();
            }
            i = j;
        }
        return k;
    }

}
