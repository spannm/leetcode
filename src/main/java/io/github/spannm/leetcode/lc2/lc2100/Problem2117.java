package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2117. Abbreviating the Product of a Range.
 */
class Problem2117 extends LeetcodeProblem {

    String abbreviateProduct(int _left, int _right) {
        int cnt2 = 0;
        int cnt5 = 0;
        for (int i = _left; i <= _right; i++) {
            int x = i;
            for (; x % 2 == 0; x /= 2) {
                cnt2++;
            }
            for (; x % 5 == 0; x /= 5) {
                cnt5++;
            }
        }
        int c = Math.min(cnt2, cnt5);
        cnt2 = cnt5 = c;
        long suf = 1;
        double pre = 1;
        boolean gt = false;
        for (int i = _left; i <= _right; i++) {
            for (suf *= i; cnt2 > 0 && suf % 2 == 0; suf /= 2) {
                cnt2--;
            }
            for (; cnt5 > 0 && suf % 5 == 0; suf /= 5) {
                cnt5--;
            }
            if (suf >= (long) 1e10) {
                gt = true;
                suf %= (long) 1e10;
            }
            for (pre *= i; pre > 1e5;) {
                pre /= 10;
            }
        }
        if (gt) {
            return (int) pre + "..." + String.format("%05d", suf % (int) 1e5) + "e" + c;
        }
        return suf + "e" + c;
    }

}
