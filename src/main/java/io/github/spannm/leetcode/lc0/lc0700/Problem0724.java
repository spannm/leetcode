package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Objects;

class Problem0724 extends LeetcodeProblem {

    int pivotIndex(int[] _nums) {
        Objects.requireNonNull(_nums);
        if (_nums.length > (int) Math.pow(10, 4)) {
            throw new IllegalArgumentException("Invalid array length");
        }

        int[] sumsl = new int[_nums.length];
        for (int i = 1; i < _nums.length; i++) {
            sumsl[i] = _nums[i - 1] + sumsl[i - 1];
        }

        int[] sumsr = new int[_nums.length];
        for (int i = _nums.length - 2; i >= 0; i--) {
            sumsr[i] = _nums[i + 1] + sumsr[i + 1];
        }

        for (int i = 0; i < _nums.length; i++) {
            if (sumsl[i] == sumsr[i]) {
                return i;
            }
        }

        return -1;
    }

}
