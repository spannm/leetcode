package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2638. Count the Number of K-Free Subsets.
 */
class Problem2638 extends LeetcodeProblem {

    long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int num : nums) {
            g.computeIfAbsent(num % k, x -> new ArrayList<>()).add(num);
        }
        long ans = 1;
        for (var arr : g.values()) {
            int m = arr.size();
            long[] f = new long[m + 1];
            f[0] = 1;
            f[1] = 2;
            for (int i = 2; i <= m; i++) {
                if (arr.get(i - 1) - arr.get(i - 2) == k) {
                    f[i] = f[i - 1] + f[i - 2];
                } else {
                    f[i] = f[i - 1] * 2;
                }
            }
            ans *= f[m];
        }
        return ans;
    }

}
