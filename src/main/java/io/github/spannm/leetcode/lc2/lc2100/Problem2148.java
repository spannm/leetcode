package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;

class Problem2148 extends LeetcodeProblem {

    int countElements(int[] _nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : _nums) {
            map.merge(num, 1, Integer::sum);
        }
        int ans = 0;
        int i = 0;
        int len = map.size();
        for (int val : map.values()) {
            if (i != 0 && i != len - 1) {
                ans += val;
            }
            i++;
        }
        return ans;
    }

}
