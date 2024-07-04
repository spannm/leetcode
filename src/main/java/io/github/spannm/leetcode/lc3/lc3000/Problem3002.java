package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 3002. Maximum Size of a Set After Removals.
 */
class Problem3002 extends LeetcodeProblem {

    int maximumSetSize(int[] _nums1, int[] _nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int x : _nums1) {
            s1.add(x);
        }
        for (int x : _nums2) {
            s2.add(x);
        }

        int n = _nums1.length;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int x : s1) {
            if (!s2.contains(x)) {
                a++;
            }
        }
        for (int x : s2) {
            if (!s1.contains(x)) {
                b++;
            } else {
                c++;
            }
        }
        a = Math.min(a, n / 2);
        b = Math.min(b, n / 2);
        return Math.min(a + b + c, n);
    }

}
