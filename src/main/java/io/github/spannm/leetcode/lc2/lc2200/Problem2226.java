package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2226. Maximum Candies Allocated to K Children.
 */
class Problem2226 extends LeetcodeProblem {

    int maximumCandies(int[] candies, long k) {
        int left = 0;
        int right = (int) 1e7;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            long cnt = 0;
            for (int v : candies) {
                cnt += v / mid;
            }
            if (cnt >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
