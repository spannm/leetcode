package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1954. Minimum Garden Perimeter to Collect Enough Apples.
 */
class Problem1954 extends LeetcodeProblem {

    long minimumPerimeter(long neededApples) {
        long l = 1;
        long r = 100000;
        while (l < r) {
            long mid = l + r >> 1;
            if (2 * mid * (mid + 1) * (2 * mid + 1) >= neededApples) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l * 8;
    }

}
