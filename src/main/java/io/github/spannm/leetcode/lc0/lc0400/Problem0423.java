package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0423 extends LeetcodeProblem {

    String originalDigits(String _s) {
        int[] counts = new int[10];
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == 'o') {
                counts[1]++;
            } else if (_s.charAt(i) == 'w') {
                counts[2]++;
            } else if (_s.charAt(i) == 'h') {
                counts[3]++;
            } else if (_s.charAt(i) == 'u') {
                counts[4]++;
            } else if (_s.charAt(i) == 'f') {
                counts[5]++;
            } else if (_s.charAt(i) == 'x') {
                counts[6]++;
            } else if (_s.charAt(i) == 'v') {
                counts[7]++;
            } else if (_s.charAt(i) == 'g') {
                counts[8]++;
            } else if (_s.charAt(i) == 'i') {
                counts[9]++;
            } else if (_s.charAt(i) == 'z') {
                counts[0]++;
            }
        }

        counts[3] -= counts[8];
        counts[5] -= counts[4];
        counts[7] -= counts[5];
        counts[1] = counts[1] - (counts[2] + counts[4] + counts[0]);
        counts[9] = counts[9] - (counts[5] + counts[6] + counts[8]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(i).repeat(Math.max(0, counts[i])));
        }
        return sb.toString();
    }

}
