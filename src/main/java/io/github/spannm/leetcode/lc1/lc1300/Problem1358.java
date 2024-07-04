package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1358 extends LeetcodeProblem {

    int numberOfSubstrings(String _s) {
        int[] counts = new int[3];
        int i = 0;
        int n = _s.length();
        int result = 0;
        for (int j = 0; j < n; j++) {
            counts[_s.charAt(j) - 'a']++;
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
                counts[_s.charAt(i++) - 'a']--;
            }
            result += i;
        }
        return result;
    }

}
