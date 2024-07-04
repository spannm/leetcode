package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1865 extends LeetcodeProblem {

    static class FindSumPairs {
        private final int[]                 nums1;
        private final int[]                 nums2;
        private final Map<Integer, Integer> cnt = new HashMap<>();

        FindSumPairs(int[] _nums1, int[] _nums2) {
            nums1 = _nums1;
            nums2 = _nums2;
            for (int v : _nums2) {
                cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            }
        }

        void add(int index, int val) {
            int old = nums2[index];
            cnt.put(old, cnt.get(old) - 1);
            cnt.put(old + val, cnt.getOrDefault(old + val, 0) + 1);
            nums2[index] += val;
        }

        int count(int tot) {
            int ans = 0;
            for (int v : nums1) {
                ans += cnt.getOrDefault(tot - v, 0);
            }
            return ans;
        }

    }

}
