package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">125. Valid Palindrome</a>.
 */
class Problem0125 extends LeetcodeProblem {

    boolean isPalindrome(String _s) {
        int left = 0;
        int right = _s.length() - 1;
        char[] chars = _s.toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
