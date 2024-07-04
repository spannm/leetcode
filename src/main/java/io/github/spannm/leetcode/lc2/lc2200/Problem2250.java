package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 2250. Count Number of Rectangles Containing Each Point.
 */
class Problem2250 extends LeetcodeProblem {

    int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = 101;
        List<List<Integer>> lol = new ArrayList<>(n);
        IntStream.range(0, n).forEach(i -> lol.add(new ArrayList<>()));
        for (int[] r : rectangles) {
            lol.get(r[1]).add(r[0]);
        }
        lol.forEach(Collections::sort);

        int m = points.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int cnt = 0;
            for (int h = y; h < n; h++) {
                List<Integer> xs = lol.get(h);
                int left = 0;
                int right = xs.size();
                while (left < right) {
                    int mid = left + right >> 1;
                    if (xs.get(mid) >= x) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                cnt += xs.size() - left;
            }
            ans[i] = cnt;
        }
        return ans;
    }

}
