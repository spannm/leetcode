package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem2134 extends LeetcodeProblem {

    int minSwaps(int[] _nums) {
        int ones = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : _nums) {
            ones += num;
            list.add(num);
        }
        for (int num : _nums) {
            list.add(num);
        }
        int minSwaps = _nums.length;
        int zeroes = 0;
        for (int left = 0, right = 0; right < list.size(); right++) {
            if (list.get(right) == 0) {
                zeroes++;
            }
            int len = right - left + 1;
            if (len < ones) {
                continue;
            } else if (len == ones) {
                minSwaps = Math.min(minSwaps, zeroes);
            } else {
                if (list.get(left) == 0) {
                    zeroes--;
                }
                left++;
                minSwaps = Math.min(minSwaps, zeroes);
            }
        }
        return minSwaps;
    }

}
