package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2526 extends LeetcodeProblem {

    static class DataStream {
        private int       cnt;
        private final int val;
        private final int k;

        DataStream(int _value, int _k) {
            val = _value;
            k = _k;
        }

        boolean consec(int num) {
            cnt = num == val ? cnt + 1 : 0;
            return cnt >= k;
        }

    }

}
