package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1599. Maximum Profit of Operating a Centennial Wheel.
 */
class Problem1599 extends LeetcodeProblem {

    int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = -1;
        int mx = 0;
        int t = 0;
        int wait = 0;
        int i = 0;
        while (wait > 0 || i < customers.length) {
            wait += i < customers.length ? customers[i] : 0;
            int up = Math.min(4, wait);
            wait -= up;
            i++;
            t += up * boardingCost - runningCost;
            if (t > mx) {
                mx = t;
                ans = i;
            }
        }
        return ans;
    }

}
