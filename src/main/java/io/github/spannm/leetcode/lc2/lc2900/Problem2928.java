package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2928. Distribute Candies Among Children I.
 */
class Problem2928 extends LeetcodeProblem {

    int distributeCandies(int n, int limit) {
        if (n > 3 * limit) {
            return 0;
        }
        long ans = comb2(n + 2);
        if (n > limit) {
            ans -= 3 * comb2(n - limit + 1);
        }
        if (n - 2 >= 2 * limit) {
            ans += 3 * comb2(n - 2 * limit);
        }
        return (int) ans;
    }

    private long comb2(int n) {
        return 1L * n * (n - 1) / 2;
    }

}
