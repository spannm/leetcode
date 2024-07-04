package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1224. Maximum Equal Frequency.
 */
class Problem1224 extends LeetcodeProblem {

    private final int[] cnt  = new int[100010];
    private final int[] ccnt = new int[100010];

    int maxEqualFreq(int[] _nums) {
        Arrays.fill(cnt, 0);
        Arrays.fill(ccnt, 0);
        int ans = 0;
        int mx = 0;
        for (int i = 1; i <= _nums.length; i++) {
            int v = _nums[i - 1];
            if (cnt[v] > 0) {
                ccnt[cnt[v]]--;
            }
            cnt[v]++;
            mx = Math.max(mx, cnt[v]);
            ccnt[cnt[v]]++;
            if (mx == 1) {
                ans = i;
            } else if (ccnt[mx] * mx + ccnt[mx - 1] * (mx - 1) == i && ccnt[mx] == 1) {
                ans = i;
            } else if (ccnt[mx] * mx + 1 == i && ccnt[1] == 1) {
                ans = i;
            }
        }
        return ans;
    }

}
