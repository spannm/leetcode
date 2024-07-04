package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0683 extends LeetcodeProblem {

    int kEmptySlots(int[] _flowers, int _k) {
        int[] days = new int[_flowers.length];
        for (int i = 0; i < _flowers.length; i++) {
            days[_flowers[i] - 1] = i + 1;
        }
        int left = 0;
        int right = _k + 1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; right < _flowers.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right) {
                    result = Math.min(result, Math.max(days[left], days[right]));
                }
                left = i;
                right = _k + 1 + i;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
