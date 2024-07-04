package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2431. Maximize Total Tastiness of Purchased Fruits.
 */
class Problem2431 extends LeetcodeProblem {

    private int[]     price;
    private int       n;
    private int[]     tastiness;
    private int[][][] f;

    int maxTastiness(int[] _price, int[] _tastiness, int _maxAmount, int _maxCoupons) {
        price = _price;
        n = _price.length;
        tastiness = _tastiness;
        f = new int[n][_maxAmount + 1][_maxCoupons + 1];
        return dfs(0, _maxAmount, _maxCoupons);
    }

    int dfs(int _i, int _j, int _k) {
        if (_i == n) {
            return 0;
        } else if (f[_i][_j][_k] != 0) {
            return f[_i][_j][_k];
        }
        int ans = dfs(_i + 1, _j, _k);
        if (_j >= price[_i]) {
            ans = Math.max(ans, dfs(_i + 1, _j - price[_i], _k) + tastiness[_i]);
        }
        if (_j >= price[_i] / 2 && _k > 0) {
            ans = Math.max(ans, dfs(_i + 1, _j - price[_i] / 2, _k - 1) + tastiness[_i]);
        }
        f[_i][_j][_k] = ans;
        return ans;
    }

}
