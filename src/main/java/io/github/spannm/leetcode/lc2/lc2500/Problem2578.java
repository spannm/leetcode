package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2578. Split With Minimum Sum.
 */
class Problem2578 extends LeetcodeProblem {

    int splitNum(int num) {
        int[] cnt = new int[10];
        int n = 0;
        for (; num > 0; num /= 10) {
            ++cnt[num % 10];
            n++;
        }
        int[] ans = new int[2];
        for (int i = 0, j = 0; i < n; i++) {
            while (cnt[j] == 0) {
                j++;
            }
            cnt[j]--;
            ans[i & 1] = ans[i & 1] * 10 + j;
        }
        return ans[0] + ans[1];
    }

}
