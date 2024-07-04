package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/first-missing-positive/">41. First Missing Positive</a>.
 */
class Problem0041 extends LeetcodeProblem {

    int firstMissingPositive(int[] _nums) {
        int[] nums = IntStream.of(_nums).filter(n -> n > 0).sorted().toArray();
        int len = nums.length;
        if (len == 0 || nums[0] > 1 || nums[len - 1] < 1) {
            return 1;
        }
        int i = 1;
        for (; i < len; i++) {
            if (nums[i] > 1 && nums[i - 1] < nums[i] - 1) {
                return nums[i - 1] + 1;
            }

        }
        return nums[i - 1] + 1;
    }

}
