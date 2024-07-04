package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1525 extends LeetcodeProblem {

    int numSplits(String _s) {
        int goodSplits = 0;
        int[] left = new int[26];
        int[] right = new int[26];
        for (int i = 0; i < _s.length(); i++) {
            char c = _s.charAt(i);
            right[c - 'a']++;
        }
        for (int i = 0; i < _s.length(); i++) {
            char c = _s.charAt(i);
            left[c - 'a']++;
            int distinctCharOnTheLeft = getDistinct(left);
            right[c - 'a']--;
            int distinctCharOnTheRight = getDistinct(right);
            if (distinctCharOnTheLeft == distinctCharOnTheRight) {
                goodSplits++;
            }
        }
        return goodSplits;
    }

    private int getDistinct(int[] _count) {
        int c = 0;
        for (int i : _count) {
            if (i != 0) {
                c++;
            }
        }
        return c;
    }

}
