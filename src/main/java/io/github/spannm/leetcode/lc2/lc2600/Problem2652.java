package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2652. Sum Multiples.
 */
class Problem2652 extends LeetcodeProblem {

    int sumOfMultiples(int n) {
        int ans = 0;
        for (int x = 1; x <= n; x++) {
            if (x % 3 == 0 || x % 5 == 0 || x % 7 == 0) {
                ans += x;
            }
        }
        return ans;
    }

}
