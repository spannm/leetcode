package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2898. Maximum Linear Stock Score.
 */
class Problem2898 extends LeetcodeProblem {

    long maxScore(int[] prices) {
        Map<Integer, Long> cnt = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            cnt.merge(prices[i] - i, (long) prices[i], Long::sum);
        }
        long ans = 0;
        for (long v : cnt.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }

}
