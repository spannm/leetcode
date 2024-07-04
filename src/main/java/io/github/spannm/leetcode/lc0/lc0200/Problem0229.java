package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0229 extends LeetcodeProblem {

    List<Integer> majorityElement(final int[] _nums) {
        if (_nums == null || _nums.length == 0) {
            return List.of();
        }

        final int len = _nums.length;
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 1;
        for (int num : _nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : _nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> results = new ArrayList<>(2);
        if (count1 > len / 3) {
            results.add(candidate1);
        }
        if (count2 > len / 3) {
            results.add(candidate2);
        }
        return results;
    }

}
