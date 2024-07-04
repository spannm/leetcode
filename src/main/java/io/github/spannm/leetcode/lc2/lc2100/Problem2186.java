package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2186 extends LeetcodeProblem {

    int minSteps(String _s, String _t) {
        int[] counts = new int[26];
        for (int i = 0; i < _s.length(); i++) {
            counts[_s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < _t.length(); i++) {
            counts[_t.charAt(i) - 'a']--;
        }
        int ans = 0;
        for (int count : counts) {
            ans += Math.abs(count);
        }
        return ans;
    }

}
