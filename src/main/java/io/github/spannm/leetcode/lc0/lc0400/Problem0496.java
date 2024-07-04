package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0496 extends LeetcodeProblem {

    int[] nextGreaterElement(int[] _nums1, int[] _nums2) {
        int[] ans = new int[_nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < _nums2.length; i++) {
            map.put(_nums2[i], i);
        }
        for (int i = 0; i < _nums1.length; i++) {
            int start = map.get(_nums1[i]);
            for (int j = start + 1; j < _nums2.length; j++) {
                if (_nums2[j] > _nums1[i]) {
                    ans[i] = _nums2[j];
                    break;
                }
            }
            if (ans[i] == 0) {
                ans[i] = -1;
            }
        }
        return ans;
    }

}
