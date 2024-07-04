package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1374 extends LeetcodeProblem {

    String generateTheString(int _n) {
        StringBuilder sb = new StringBuilder();
        if (_n > 1 && _n % 2 == 0) {
            while (_n-- > 1) {
                sb.append("a");
            }
        } else if (_n > 1) {
            while (_n-- > 2) {
                sb.append("a");
            }
            sb.append("b");
        }
        sb.append("z");
        return sb.toString();
    }

}
