package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2643. Row With Maximum Ones.
 */
class Problem2643 extends LeetcodeProblem {

    int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int x : mat[i]) {
                if (x == 1) {
                    cnt++;
                }
            }
            if (ans[1] < cnt) {
                ans[0] = i;
                ans[1] = cnt;
            }
        }
        return ans;
    }

}
