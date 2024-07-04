package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

/**
 * <a href="https://leetcode.com/problems/4sum/">18. 4Sum</a>.
 */
class Problem0018 extends LeetcodeProblem {

    List<List<Integer>> fourSum(int[] _nums, final int _target) {
        final int len = _nums.length;
        if (len <= 4) {
            if (len == 4 && Arrays.stream(_nums).mapToLong(i -> i).sum() == _target) {
                return List.of(Arrays.stream(_nums).boxed().toList());
            }
            return List.of();
        }

        long[] nums = Arrays.stream(_nums).sorted().mapToLong(i -> i).toArray();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long twoSumTarget = _target - nums[i] - nums[j];
                // The following 3 lines of code to calculate the min and max of twoSum
                long minTwoSum = nums[j + 1] + nums[j + 2];
                long maxTwoSum = nums[len - 1] + nums[len - 2];
                if (twoSumTarget < minTwoSum || twoSumTarget > maxTwoSum) {
                    continue;
                }
                for (int m = j + 1, n = len - 1; m < n;) {
                    long twoSum = nums[m] + nums[n];
                    if (twoSum < twoSumTarget) {
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        m++;
                    } else if (twoSum > twoSumTarget) {
                        while (m < n && nums[n] == nums[n - 1]) {
                            n--;
                        }
                        n--;
                    } else {
                        results.add(new ArrayList<>(LongStream.of(nums[i], nums[j], nums[m], nums[n]).mapToInt(l -> (int) l).boxed().toList()));
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        m++;
                        while (m < n && nums[n] == nums[n - 1]) {
                            n--;
                        }
                        n--;
                    }
                }
            }
        }
        return results;
    }

}
