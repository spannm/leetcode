package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0481 extends LeetcodeProblem {

    int magicalString(int _n) {
        if (_n <= 0) {
            return 0;
        } else if (_n <= 3) {
            return 1;
        }

        int[] a = new int[_n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;

        int head = 2;
        int tail = 3;
        int num = 1;
        int result = 1;

        while (tail < _n) {
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1 && tail < _n) {
                    result++;
                }
                tail++;
            }
            num = num ^ 3;
            head++;
        }

        return result;
    }

}
