package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2417. Closest Fair Integer.
 */
class Problem2417 extends LeetcodeProblem {

    int closestFair(int n) {
        int a = 0;
        int b = 0;
        int k = 0;
        int t = n;
        while (t > 0) {
            if (t % 10 % 2 == 1) {
                a++;
            } else {
                b++;
            }
            t /= 10;
            k++;
        }
        if (k % 2 == 1) {
            int x = (int) Math.pow(10, k);
            int y = 0;
            for (int i = 0; i < k >> 1; i++) {
                y = y * 10 + 1;
            }
            return x + y;
        }
        if (a == b) {
            return n;
        }
        return closestFair(n + 1);
    }

}
