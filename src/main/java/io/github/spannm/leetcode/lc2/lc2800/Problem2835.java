package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2835. Minimum Operations to Form Subsequence With Target Sum.
 */
class Problem2835 extends LeetcodeProblem {

    int minOperations(List<Integer> nums, int target) {
        long s = 0;
        int[] cnt = new int[32];
        for (int x : nums) {
            s += x;
            for (int i = 0; i < 32; i++) {
                if ((x >> i & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        if (s < target) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        while (true) {
            while (i < 32 && (target >> i & 1) == 0) {
                i++;
            }
            if (i == 32) {
                return ans;
            }
            while (j < i) {
                cnt[j + 1] += cnt[j] / 2;
                cnt[j] %= 2;
                j++;
            }
            while (cnt[j] == 0) {
                cnt[j] = 1;
                j++;
            }
            ans += j - i;
            cnt[j]--;
            j = i;
            i++;
        }
    }

}
