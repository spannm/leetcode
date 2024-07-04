package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">516. Longest Palindromic Subsequence</a>.
 */
class Problem0516 extends LeetcodeProblem {

    int longestPalindromeSubseq(String _str) {
        final int len = _str == null ? 0 : _str.length();
        if (len == 0) {
            return 0;
        }
        final int[][] chache = new int[len][len];
        for (int[] row : chache) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return findLongestPalindrome(_str, 0, len - 1, chache);
    }

    static int findLongestPalindrome(String _str, int _left, int _right, int[][] _cache) {
        if (_left == _right) {
            return 1;
        } else if (_left > _right) {
            return 0;
        } else if (_cache[_left][_right] >= 0) {
            return _cache[_left][_right];
        } else if (_str.charAt(_left) == _str.charAt(_right)) {
            _cache[_left][_right] = 2 + findLongestPalindrome(_str, _left + 1, _right - 1, _cache);
            return _cache[_left][_right];
        }

        int leftIncrement = findLongestPalindrome(_str, _left + 1, _right, _cache);
        int rightIncrement = findLongestPalindrome(_str, _left, _right - 1, _cache);

        _cache[_left][_right] = Math.max(leftIncrement, rightIncrement);

        return _cache[_left][_right];
    }

}
