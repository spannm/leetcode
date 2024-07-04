package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1313 extends LeetcodeProblem {

    int[] decompressRLElist(int[] _nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < _nums.length - 1; i += 2) {
            int count = _nums[i];
            int value = _nums[i + 1];
            while (count-- > 0) {
                list.add(value);
            }
        }
        return list.stream().mapToInt(integer -> integer).toArray();
    }

}
