package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0076 extends LeetcodeProblem {

    String minWindow(String _s, String _t) {
        int[] counts = new int[256];
        for (char c : _t.toCharArray()) {
            counts[c]++;
        }

        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = _t.length();
        while (end < _s.length()) {
            if (counts[_s.charAt(end)] > 0) {
                counter--;
            }

            counts[_s.charAt(end)]--;
            end++;

            while (counter == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                counts[_s.charAt(start)]++;
                if (counts[_s.charAt(start)] > 0) {
                    counter++;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : _s.substring(minStart, minStart + minLen);
    }

}
