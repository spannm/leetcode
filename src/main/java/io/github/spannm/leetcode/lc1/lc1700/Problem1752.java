package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1752 extends LeetcodeProblem {

    boolean check(int[] _nums) {
        int[] copy = Arrays.copyOf(_nums, _nums.length);
        Arrays.sort(copy);
        for (int i = 1; i <= _nums.length; i++) {
            int[] rotated = rotate(_nums, i);
            if (Arrays.equals(rotated, copy)) {
                return true;
            }
        }
        return false;
    }

    private int[] rotate(int[] _nums, int _start) {
        int[] rotated = new int[_nums.length];
        int j = 0;
        for (int i = _start; i < _nums.length; i++, j++) {
            rotated[j] = _nums[i];
        }
        for (int i = 0; i < _start; i++) {
            rotated[j++] = _nums[i];
        }
        return rotated;
    }

}
