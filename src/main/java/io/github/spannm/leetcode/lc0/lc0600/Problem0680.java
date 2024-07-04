package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0680 extends LeetcodeProblem {

    boolean validPalindrome(String _s) {
        int left = 0;
        int right = _s.length() - 1;
        int diff = 0;
        while (left < right) {
            if (_s.charAt(left) != _s.charAt(right)) {
                left++;
                diff++;
                if (diff > 1) {
                    break;
                }
            } else {
                left++;
                right--;
            }
        }
        if (diff < 2) {
            return true;
        }
        diff = 0;
        left = 0;
        right = _s.length() - 1;
        while (left < right) {
            if (_s.charAt(left) != _s.charAt(right)) {
                right--;
                diff++;
                if (diff > 1) {
                    break;
                }
            } else {
                left++;
                right--;
            }
        }
        return diff < 2;
    }

}
