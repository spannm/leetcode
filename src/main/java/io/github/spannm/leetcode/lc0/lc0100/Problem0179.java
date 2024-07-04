package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/largest-number/">179. Largest Number</a>.
 */
class Problem0179 extends LeetcodeProblem {

    String largestNumber(int[] _nums) {
        int len = _nums.length;
        if (len <= 1) {
            if (len == 1) {
                return Integer.toString(_nums[0]);
            }
            return "";
        }

        final String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = Integer.toString(_nums[i]);
        }

        Arrays.sort(strs, (p1, p2) -> {
            String s1 = p1 + p2;
            String s2 = p2 + p1;
            return s2.compareTo(s1);
        });

        if (strs[0].charAt(0) == '0') {
            return "0";
        }
        return String.join("", strs);
    }

}
