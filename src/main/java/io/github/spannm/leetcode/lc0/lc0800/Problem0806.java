package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0806 extends LeetcodeProblem {

    int[] numberOfLines(int[] _widths, String _s) {
        int numOfLines = 1;
        int offsetInCurrentLine = 0;
        for (char c : _s.toCharArray()) {
            if (offsetInCurrentLine + _widths[c - 'a'] < 100) {
                offsetInCurrentLine += _widths[c - 'a'];
            } else if (offsetInCurrentLine + _widths[c - 'a'] == 100) {
                numOfLines++;
                offsetInCurrentLine = 0;
            } else {
                numOfLines++;
                offsetInCurrentLine = _widths[c - 'a'];
            }
        }
        return new int[] {numOfLines, offsetInCurrentLine};
    }

}
