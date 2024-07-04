package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2271. Maximum White Tiles Covered by a Carpet.
 */
class Problem2271 extends LeetcodeProblem {

    int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int n = tiles.length;
        int s = 0;
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && tiles[j][1] - tiles[i][0] + 1 <= carpetLen) {
                s += tiles[j][1] - tiles[j][0] + 1;
                j++;
            }
            if (j < n && tiles[i][0] + carpetLen > tiles[j][0]) {
                ans = Math.max(ans, s + tiles[i][0] + carpetLen - tiles[j][0]);
            } else {
                ans = Math.max(ans, s);
            }
            s -= tiles[i][1] - tiles[i][0] + 1;
        }
        return ans;
    }

}
