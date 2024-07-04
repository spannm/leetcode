package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Problem2248 extends LeetcodeProblem {

    List<Integer> intersection(int[][] _nums) {
        int[] inter = _nums[0];
        for (int[] num : _nums) {
            inter = intersection(num, inter);
        }
        Arrays.sort(inter);
        List<Integer> list = new ArrayList<>();
        for (int element : inter) {
            list.add(element);
        }
        return list;
    }

    int[] intersection(int[] _nums1, int[] _nums2) {
        Set<Integer> set1 = Arrays.stream(_nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(_nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        int[] intersection = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            intersection[i++] = num;
        }
        return intersection;
    }

}
