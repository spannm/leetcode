package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 777. Swap Adjacent in LR String.
 */
class Problem0777 extends LeetcodeProblem {

    boolean canTransform(String _start, String _end) {
        int len = _start.length();
        int i = 0;
        int j = 0;
        while (true) {
            while (i < len && _start.charAt(i) == 'X') {
                i++;
            }
            while (j < len && _end.charAt(j) == 'X') {
                j++;
            }
            if (i == len && j == len) {
                return true;
            }
            if (i == len || j == len || _start.charAt(i) != _end.charAt(j)) {
                return false;
            }
            if (_start.charAt(i) == 'L' && i < j || _start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
    }

}
