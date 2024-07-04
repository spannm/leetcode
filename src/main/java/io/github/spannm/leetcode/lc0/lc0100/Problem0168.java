package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/excel-sheet-column-title/">168. Excel Sheet Column Title</a>.
 */
class Problem0168 extends LeetcodeProblem {

    String convertToTitle(int _columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (_columnNumber > 0) {
            _columnNumber--;
            int remainder = _columnNumber % 26;
            sb.append((char) ('A' + remainder));
            _columnNumber /= 26;
        }
        String result = sb.reverse().toString();
        sb = null;
        return result;
    }

}
