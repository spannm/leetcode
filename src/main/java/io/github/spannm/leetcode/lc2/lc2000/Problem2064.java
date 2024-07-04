package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2064. Minimized Maximum of Products Distributed to Any Store.
 */
class Problem2064 extends LeetcodeProblem {

    int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = (int) 1e5;
        while (left < right) {
            int mid = left + right >> 1;
            int cnt = 0;
            for (int v : quantities) {
                cnt += (v + mid - 1) / mid;
            }
            if (cnt <= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
