package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem2108 extends LeetcodeProblem {

    String firstPalindrome(String[] _words) {
        return Arrays.stream(_words).filter(w -> {
            int left = 0;
            int right = w.length() - 1;
            while (left < right) {
                if (w.charAt(left) != w.charAt(right)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
            return true;
        }).findFirst().orElse("");
    }

}
