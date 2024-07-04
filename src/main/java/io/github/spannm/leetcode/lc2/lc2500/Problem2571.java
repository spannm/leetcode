package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2571. Minimum Operations to Reduce an Integer to 0.
 */
class Problem2571 extends LeetcodeProblem {

    int minOperations(int n) {
        int ans = 0;
        int cnt = 0;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                cnt++;
            } else if (cnt > 0) {
                ans++;
                cnt = cnt == 1 ? 0 : 1;
            }
        }
        ans += cnt == 1 ? 1 : 0;
        ans += cnt > 1 ? 2 : 0;
        return ans;
    }

}
