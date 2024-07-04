package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1925 extends LeetcodeProblem {

    int countTriples(int _n) {
        int count = 0;
        for (int i = 1; i < _n; i++) {
            for (int j = 1; j < _n; j++) {
                int product = i * i + j * j;
                double sq = Math.sqrt(product);
                if (sq <= _n && sq - Math.floor(sq) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
