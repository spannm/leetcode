package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2137. Pour Water Between Buckets to Make Water Levels Equal.
 */
class Problem2137 extends LeetcodeProblem {

    double equalizeWater(int[] buckets, int loss) {
        double l = 0;
        double r = Arrays.stream(buckets).max().getAsInt();
        while (r - l > 1e-5) {
            double mid = (l + r) / 2;
            if (check(buckets, loss, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean check(int[] buckets, int loss, double v) {
        double a = 0;
        double b = 0;
        for (int x : buckets) {
            if (x > v) {
                a += x - v;
            } else {
                b += (v - x) * 100 / (100 - loss);
            }
        }
        return a >= b;
    }

}
