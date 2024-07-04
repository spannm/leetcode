package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2195. Append K Integers With Minimal Sum.
 */
class Problem2195 extends LeetcodeProblem {

    long minimalKSum(int[] nums, int k) {
        int[] arr = new int[nums.length + 2];
        arr[arr.length - 1] = (int) 2e9;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 1; i < arr.length; i++) {
            int a = arr[i - 1];
            int b = arr[i];
            int n = Math.min(k, b - a - 1);
            if (n <= 0) {
                continue;
            }
            k -= n;
            ans += (long) (a + 1 + a + n) * n / 2;
            if (k == 0) {
                break;
            }
        }
        return ans;
    }

}
