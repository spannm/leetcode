package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2967. Minimum Cost to Make Array Equalindromic.
 */
class Problem2967 extends LeetcodeProblem {

    private static final long[] PS;
    private int[]               nums;

    static {
        PS = new long[2 * (int) 1e5];
        for (int i = 1; i <= 1e5; i++) {
            String s = Integer.toString(i);
            String t1 = new StringBuilder(s).reverse().toString();
            String t2 = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
            PS[2 * i - 2] = Long.parseLong(s + t1);
            PS[2 * i - 1] = Long.parseLong(s + t2);
        }
        Arrays.sort(PS);
    }

    long minimumCost(int[] _nums) {
        nums = _nums;
        Arrays.sort(_nums);
        int i = Arrays.binarySearch(PS, _nums[_nums.length / 2]);
        i = i < 0 ? -i - 1 : i;
        long ans = 1L << 60;
        for (int j = i - 1; j <= i + 1; j++) {
            if (0 <= j && j < PS.length) {
                ans = Math.min(ans, f(PS[j]));
            }
        }
        return ans;
    }

    private long f(long x) {
        long ans = 0;
        for (int v : nums) {
            ans += Math.abs(v - x);
        }
        return ans;
    }

}
