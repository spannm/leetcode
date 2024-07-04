package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * 665. Non-decreasing Array.
 */
class Problem0665 extends LeetcodeProblem {

    boolean checkPossibility(int[] _nums) {
        for (int i = 0; i < _nums.length - 1; i++) {
            int a = _nums[i];
            int b = _nums[i + 1];
            if (a > b) {
                _nums[i] = b;
                if (isSorted(_nums)) {
                    return true;
                }
                _nums[i] = a;
                _nums[i + 1] = a;
                return isSorted(_nums);
            }
        }
        return true;
    }

    static boolean isSorted(int[] _nums) {
        return IntStream.range(0, _nums.length - 1).filter(i -> _nums[i] > _nums[i + 1]).findAny().isEmpty();
    }

}
