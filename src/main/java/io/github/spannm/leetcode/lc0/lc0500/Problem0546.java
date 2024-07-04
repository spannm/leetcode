package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 546. Remove Boxes.
 */
class Problem0546 extends LeetcodeProblem {

    int removeBoxes(int[] _boxes) {
        int len = _boxes.length;
        return dfs(0, len - 1, 0, _boxes, new int[len][len][len]);
    }

    static int dfs(int i, int j, int k, int[] _boxes, int[][][] _dp) {
        if (i > j) {
            return 0;
        }
        while (i < j && _boxes[j] == _boxes[j - 1]) {
            j--;
            k++;
        }
        if (_dp[i][j][k] > 0) {
            return _dp[i][j][k];
        }
        int ans = dfs(i, j - 1, 0, _boxes, _dp) + (k + 1) * (k + 1);
        for (int h = i; h < j; h++) {
            if (_boxes[h] == _boxes[j]) {
                ans = Math.max(ans, dfs(h + 1, j - 1, 0, _boxes, _dp) + dfs(i, h, k + 1, _boxes, _dp));
            }
        }
        _dp[i][j][k] = ans;
        return ans;
    }

}
