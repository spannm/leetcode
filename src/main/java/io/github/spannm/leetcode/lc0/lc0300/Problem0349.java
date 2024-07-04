package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Problem0349 extends LeetcodeProblem {

    int[] intersection(int[] _nums1, int[] _nums2) {
        Set<Integer> nums2 = Arrays.stream(_nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(_nums1).boxed().distinct().filter(nums2::contains).mapToInt(i -> i).toArray();
    }

}
