package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2602. Minimum Operations to Make All Array Elements Equal.
 */
class Problem2602 extends LeetcodeProblem {

    List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        List<Long> ans = new ArrayList<>();
        for (int x : queries) {
            int i = search(nums, x + 1);
            long t = s[n] - s[i] - 1L * (n - i) * x;
            i = search(nums, x);
            t += 1L * x * i - s[i];
            ans.add(t);
        }
        return ans;
    }

    private int search(int[] nums, int x) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
