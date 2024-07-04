package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2948. Make Lexicographically Smallest Array by Swapping Elements.
 */
class Problem2948 extends LeetcodeProblem {

    int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> nums[i]));
        int[] ans = new int[n];
        for (int i = 0; i < n;) {
            int j = i + 1;
            while (j < n && nums[idx[j]] - nums[idx[j - 1]] <= limit) {
                j++;
            }
            Integer[] t = Arrays.copyOfRange(idx, i, j);
            Arrays.sort(t, Comparator.comparingInt(x -> x));
            for (int k = i; k < j; k++) {
                ans[t[k - i]] = nums[idx[k]];
            }
            i = j;
        }
        return ans;
    }

}
