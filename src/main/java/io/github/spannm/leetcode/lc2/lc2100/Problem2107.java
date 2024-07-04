package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2107. Number of Unique Flavors After Sharing K Candies.
 */
class Problem2107 extends LeetcodeProblem {

    int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = candies.length;
        for (int i = k; i < n; i++) {
            cnt.merge(candies[i], 1, Integer::sum);
        }
        int ans = cnt.size();
        for (int i = k; i < n; i++) {
            cnt.merge(candies[i - k], 1, Integer::sum);
            if (cnt.merge(candies[i], -1, Integer::sum) == 0) {
                cnt.remove(candies[i]);
            }
            ans = Math.max(ans, cnt.size());
        }
        return ans;
    }

}
