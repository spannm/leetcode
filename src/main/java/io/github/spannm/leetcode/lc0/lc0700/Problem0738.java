package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0738 extends LeetcodeProblem {

    int monotoneIncreasingDigits(int _n) {
        String s = Integer.toString(_n);
        int index = -1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) > s.charAt(i + 1) || index != -1 && s.charAt(index) == s.charAt(i)) {
                index = i;
            }
        }
        return index == -1 ? _n : _n - Integer.parseInt(s.substring(index + 1)) - 1;
    }

}
