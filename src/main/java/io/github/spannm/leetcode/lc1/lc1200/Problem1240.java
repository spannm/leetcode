package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1240. Tiling a Rectangle with the Fewest Squares.
 */
class Problem1240 extends LeetcodeProblem {

    private int   n;
    private int   m;
    private int[] filled;
    private int   ans;

    int tilingRectangle(int _n, int _m) {
        n = _n;
        m = _m;
        ans = _n * _m;
        filled = new int[_n];
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int _i, int _j, int _t) {
        if (_j == m) {
            _i++;
            _j = 0;
        }
        if (_i == n) {
            ans = _t;
            return;
        }
        if ((filled[_i] >> _j & 1) == 1) {
            dfs(_i, _j + 1, _t);
        } else if (_t + 1 < ans) {
            int r = 0;
            int c = 0;
            for (int k = _i; k < n; k++) {
                if ((filled[k] >> _j & 1) == 1) {
                    break;
                }
                r++;
            }
            for (int k = _j; k < m; k++) {
                if ((filled[_i] >> k & 1) == 1) {
                    break;
                }
                c++;
            }
            int mx = Math.min(r, c);
            for (int x = _i; x < _i + mx; x++) {
                for (int y = _j; y < _j + mx; y++) {
                    filled[x] |= 1 << y;
                }
            }
            for (int w = mx; w > 0; w--) {
                dfs(_i, _j + w, _t + 1);
                for (int k = 0; k < w; k++) {
                    filled[_i + w - 1] ^= 1 << _j + k;
                    if (k < w - 1) {
                        filled[_i + k] ^= 1 << _j + w - 1;
                    }
                }
            }
        }
    }

}
