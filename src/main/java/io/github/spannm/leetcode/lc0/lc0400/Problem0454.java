package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II.
 */
class Problem0454 extends LeetcodeProblem {

    int fourSumCount(int[] _nums1, int[] _nums2, int[] _nums3, int[] _nums4) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n1 : _nums1) {
            for (int n2 : _nums2) {
                counts.merge(n1 + n2, 1, Integer::sum);
            }
        }
        int result = 0;
        for (int n3 : _nums3) {
            for (int n4 : _nums4) {
                result += counts.getOrDefault(-(n3 + n4), 0);
            }
        }
        counts = null;
        return result;
    }

}
