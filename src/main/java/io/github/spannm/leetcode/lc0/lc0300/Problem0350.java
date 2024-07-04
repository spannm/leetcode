package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 350. Intersection of Two Arrays II.
 */
class Problem0350 extends LeetcodeProblem {

    int[] intersect(int[] _nums1, int[] _nums2) {
        int[] counts = new int[1001];
        Arrays.stream(_nums1).forEach(n -> counts[n]++);
        return Arrays.stream(_nums2).filter(n -> counts[n]-- > 0).toArray();
    }

}
