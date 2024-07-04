package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2023 extends LeetcodeProblem {

    int numOfPairs(String[] _nums, String _target) {
        int ans = 0;
        for (int i = 0; i < _nums.length; i++) {
            for (int j = 0; j < _nums.length; j++) {
                if (i != j) {
                    String con = _nums[i] + _nums[j];
                    if (con.equals(_target)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
