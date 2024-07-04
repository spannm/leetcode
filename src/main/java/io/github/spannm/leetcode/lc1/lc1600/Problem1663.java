package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1663 extends LeetcodeProblem {

    String getSmallestString(int _n, int _k) {
        StringBuilder sb = new StringBuilder();
        int balance = _k - _n;
        while (balance > 0) {
            if (balance > 25) {
                balance -= 25;
                sb.append("z");
                _n--;
            } else {
                char str = (char) ('a' + balance);
                sb.append(str);
                _n--;
                while (_n > 0) {
                    sb.append("a");
                    _n--;
                }
                break;
            }
        }
        return sb.reverse().toString();
    }

}
