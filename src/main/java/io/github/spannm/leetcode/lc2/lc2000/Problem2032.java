package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem2032 extends LeetcodeProblem {

    List<Integer> twoOutOfThree(int[] _nums1, int[] _nums2, int[] _nums3) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i : _nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : _nums2) {
            set2.add(i);
        }
        Set<Integer> set3 = new HashSet<>();
        for (int i : _nums3) {
            set3.add(i);
        }
        for (int element : _nums1) {
            if (set2.contains(element) || set3.contains(element)) {
                ans.add(element);
            }
        }
        for (int element : _nums2) {
            if (set1.contains(element) || set3.contains(element)) {
                ans.add(element);
            }
        }
        for (int element : _nums3) {
            if (set1.contains(element) || set2.contains(element)) {
                ans.add(element);
            }
        }
        return new ArrayList<>(ans);
    }

}
