package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1775 extends LeetcodeProblem {

    int minOperations(int[] _nums1, int[] _nums2) {
        int[] longer = _nums1.length > _nums2.length ? _nums1 : _nums2;
        int[] shorter = _nums1.length > _nums2.length ? _nums2 : _nums1;
        if (longer.length > shorter.length * 6) {
            return -1;
        }
        Arrays.sort(longer);
        Arrays.sort(shorter);
        int i = 0;
        int j = 0;
        int diff = 0;
        while (i < longer.length || j < shorter.length) {
            if (i < longer.length) {
                diff += longer[i++];
            }
            if (j < shorter.length) {
                diff -= shorter[j++];
            }
        }
        int minOps = 0;
        i = 0;
        j = shorter.length - 1;
        if (diff < 0) {
            while (diff < 0) {
                if (i < longer.length && j >= 0) {
                    if (6 - longer[i] < shorter[j] - 1) {
                        diff += shorter[j--] - 1;
                    } else {
                        diff += 6 - longer[i++];
                    }
                } else if (i < longer.length) {
                    diff += 6 - longer[i++];
                } else {
                    diff += shorter[j--] - 1;
                }
                minOps++;
            }
            return minOps;
        } else if (diff > 0) {
            i = longer.length - 1;
            j = 0;
            while (diff > 0) {
                if (i >= 0 && j < shorter.length) {
                    if (longer[i] - 1 > 6 - shorter[j]) {
                        diff -= longer[i--] - 1;
                    } else {
                        diff -= 6 - shorter[j++];
                    }
                } else if (i >= 0) {
                    diff -= longer[i--] - 1;
                } else {
                    diff -= 6 - shorter[j++];
                }
                minOps++;
            }
            return minOps;
        } else {
            return minOps;
        }
    }

}
