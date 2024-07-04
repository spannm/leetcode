package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2280. Minimum Lines to Represent a Line Chart.
 */
class Problem2280 extends LeetcodeProblem {

    int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int dx = 0;
        int dy = 1;
        int ans = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            int x = stockPrices[i - 1][0];
            int y = stockPrices[i - 1][1];
            int x1 = stockPrices[i][0];
            int y1 = stockPrices[i][1];
            int dx1 = x1 - x;
            int dy1 = y1 - y;
            if (dy * dx1 != dx * dy1) {
                ans++;
            }
            dx = dx1;
            dy = dy1;
        }
        return ans;
    }

}
