package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0548 extends LeetcodeProblem {

    boolean splitArray(int[] _nums) {
        int len = _nums.length;
        if (len < 7) {
            return false;
        }
        int[] sum = new int[len];
        sum[0] = _nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + _nums[i];
        }
        for (int j = 3; j < len - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }
            for (int k = j + 2; k < len - 1; k++) {
                if (sum[k - 1] - sum[j] == sum[len - 1] - sum[k] && set.contains(sum[k - 1] - sum[j])) {
                    return true;
                }
            }
        }
        return false;
    }

}
