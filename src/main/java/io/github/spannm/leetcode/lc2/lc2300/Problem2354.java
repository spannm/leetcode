package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2354. Number of Excellent Pairs.
 */
class Problem2354 extends LeetcodeProblem {

    long countExcellentPairs(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        long ans = 0;
        int[] cnt = new int[32];
        for (int v : s) {
            int t = Integer.bitCount(v);
            cnt[t]++;
        }
        for (int v : s) {
            int t = Integer.bitCount(v);
            for (int i = 0; i < 32; i++) {
                if (t + i >= k) {
                    ans += cnt[i];
                }
            }
        }
        return ans;
    }

}
