package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2370. Longest Ideal Subsequence.
 */
class Problem2370 extends LeetcodeProblem {

    int longestIdealString(String _s, int _k) {
        int len = _s.length();
        int result = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Map<Character, Integer> d = new HashMap<>(26);
        d.put(_s.charAt(0), 0);
        for (int i = 1; i < len; i++) {
            char c1 = _s.charAt(i);
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (Math.abs(c1 - c2) <= _k) {
                    Integer val = d.get(c2);
                    if (val != null) {
                        dp[i] = Math.max(dp[i], dp[val] + 1);
                    }
                }
            }
            d.put(c1, i);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
