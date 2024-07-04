package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3007. Maximum Number That Sum of the Prices Is Less Than or Equal to K.
 */
class Problem3007 extends LeetcodeProblem {

    private int      x;
    private long     num;
    private Long[][] f;

    long findMaximumNumber(long _k, int _x) {
        x = _x;
        long l = 1;
        long r = (long) 1e17;
        while (l < r) {
            long mid = l + r + 1 >>> 1;
            num = mid;
            f = new Long[65][65];
            int pos = 64 - Long.numberOfLeadingZeros(mid);
            if (dfs(pos, 0, true) <= _k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private long dfs(int pos, int cnt, boolean limit) {
        if (pos == 0) {
            return cnt;
        }
        if (!limit && f[pos][cnt] != null) {
            return f[pos][cnt];
        }
        long ans = 0;
        int up = limit ? (int) (num >> pos - 1 & 1) : 1;
        for (int i = 0; i <= up; i++) {
            ans += dfs(pos - 1, cnt + (i == 1 && pos % x == 0 ? 1 : 0), limit && i == up);
        }
        if (!limit) {
            f[pos][cnt] = ans;
        }
        return ans;
    }

}
