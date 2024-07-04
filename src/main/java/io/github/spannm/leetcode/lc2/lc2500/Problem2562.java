package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2562 extends LeetcodeProblem {

    long findTheArrayConcVal(int[] _nums) {
        long sum = 0;
        int left = 0;
        int right = _nums.length - 1;
        while (left < right) {
            int first = _nums[left++];
            int last = _nums[right--];
            int times = 1;
            sum += last;
            while (last != 0) {
                last /= 10;
                times *= 10;
            }
            sum += (long) first * times;
        }
        if (left == right) {
            sum += _nums[left];
        }
        return sum;
    }

}
