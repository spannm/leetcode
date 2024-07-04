package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2960. Count Tested Devices After Test Operations.
 */
class Problem2960 extends LeetcodeProblem {

    int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int x : batteryPercentages) {
            x -= ans;
            if (x > 0) {
                ans++;
            }
        }
        return ans;
    }

}
