package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1608 extends LeetcodeProblem {

    int specialArray(int[] _nums) {
        Arrays.sort(_nums);
        int len = _nums.length;
        int max = _nums[len - 1];
        for (int x = 1; x <= max; x++) {
            int found = 0;
            int i = len - 1;
            while (i >= 0 && _nums[i] >= x) {
                i--;
                found++;
            }
            if (found == x) {
                return x;
            }
        }
        return -1;
    }

}
