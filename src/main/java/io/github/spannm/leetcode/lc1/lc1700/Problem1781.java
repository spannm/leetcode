package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1781 extends LeetcodeProblem {

    int beautySum(String _s) {
        int sum = 0;
        for (int i = 0; i < _s.length(); i++) {
            int[] charCount = new int[26];
            for (int j = i; j < _s.length(); j++) {
                charCount[_s.charAt(j) - 'a']++;

                int beauty = getMaxCount(charCount) - getMinCount(charCount);
                sum += beauty;
            }
        }
        return sum;
    }

    private int getMinCount(int[] _charCount) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (_charCount[i] != 0) {
                min = Math.min(min, _charCount[i]);
            }
        }
        return min;
    }

    private int getMaxCount(int[] _charCount) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (_charCount[i] != 0) {
                max = Math.max(max, _charCount[i]);
            }
        }
        return max;
    }

}
