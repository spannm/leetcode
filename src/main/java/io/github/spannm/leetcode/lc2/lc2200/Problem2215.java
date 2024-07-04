package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">2215. Find the Difference of Two
 * Arrays</a>.
 */
class Problem2215 extends LeetcodeProblem {

    List<List<Integer>> findDifference(int[] _nums1, int[] _nums2) {
        Arrays.sort(_nums1);
        Arrays.sort(_nums2);

        List<Integer> nums1 = Arrays.stream(_nums1)
            .filter(n -> Arrays.binarySearch(_nums2, n) < 0)
            .distinct()
            .boxed()
            .toList();

        List<Integer> nums2 = Arrays.stream(_nums2)
            .filter(n -> Arrays.binarySearch(_nums1, n) < 0)
            .distinct()
            .boxed()
            .toList();

        return List.of(nums1, nums2);
    }

}
