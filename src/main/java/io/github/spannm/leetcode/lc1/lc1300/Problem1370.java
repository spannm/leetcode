package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1370 extends LeetcodeProblem {

    String sortString(String _s) {
        int[] count = new int[26];
        for (char c : _s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < _s.length()) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    char character = (char) (i + 'a');
                    sb.append(character);
                    count[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    char character = (char) (i + 'a');
                    sb.append(character);
                    count[i]--;
                }
            }
        }
        return sb.toString();
    }

}
