package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0395 extends LeetcodeProblem {

    int longestSubstring(String _s, int _k) {
        return findLongestSubstring(_s.toCharArray(), 0, _s.length(), _k);
    }

    static int findLongestSubstring(char[] _chars, int _start, int _end, int _k) {
        if (_end - _start < _k) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = _start; i < _end; i++) {
            int index = _chars[i] - 'a';
            count[index]++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < _k && count[i] > 0) {
                for (int j = _start; j < _end; j++) {
                    if (_chars[j] == i + 'a') {
                        int left = findLongestSubstring(_chars, _start, j, _k);
                        int right = findLongestSubstring(_chars, j + 1, _end, _k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return _end - _start;
    }

}
