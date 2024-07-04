package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0848 extends LeetcodeProblem {

    String shiftingLetters(String _s, int[] _shifts) {
        long[] preSums = new long[_shifts.length];
        for (int i = _shifts.length - 1; i >= 0; i--) {
            if (i < _shifts.length - 1) {
                preSums[i] = preSums[i + 1] + _shifts[i];
            } else {
                preSums[i] = _shifts[i];
            }
            preSums[i] %= 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _s.length(); i++) {
            int newChar = _s.charAt(i) + (int) preSums[i] % 26;
            if (newChar > 122) {
                sb.append((char) (newChar - 122 + 96));
            } else {
                sb.append((char) newChar);
            }
        }
        return sb.toString();
    }

}
