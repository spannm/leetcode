package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1814 extends LeetcodeProblem {

    int countNicePairs(int[] _nums) {
        final int len = _nums.length;
        long[] reverses = new long[len];
        for (int i = 0; i < len; i++) {
            long reverse = 0;
            int num = _nums[i];
            while (num != 0) {
                reverse = reverse * 10 + num % 10;
                num /= 10;
            }
            reverses[i] = reverse;
        }

        Map<Long, Integer> map = new HashMap<>();
        long nicePairs = 0;
        for (int i = 0; i < len; i++) {
            long diff = _nums[i] - reverses[i];
            map.compute(diff, (k, v) -> v == null ? 1 : v + 1);
            nicePairs = (nicePairs + map.get(_nums[i] - reverses[i]) - 1) % 1000000007;
        }

        int result = (int) nicePairs;

        _nums = null;
        reverses = null;
        map = null;
        System.gc();

        return result;
    }

}
