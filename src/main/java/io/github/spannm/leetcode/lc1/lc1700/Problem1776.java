package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1776. Car Fleet II.
 */
class Problem1776 extends LeetcodeProblem {

    double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty()) {
                int j = stk.peek();
                if (cars[i][1] > cars[j][1]) {
                    double t = (cars[j][0] - cars[i][0]) * 1.0 / (cars[i][1] - cars[j][1]);
                    if (ans[j] < 0 || t <= ans[j]) {
                        ans[i] = t;
                        break;
                    }
                }
                stk.pop();
            }
            stk.push(i);
        }
        return ans;
    }

}
