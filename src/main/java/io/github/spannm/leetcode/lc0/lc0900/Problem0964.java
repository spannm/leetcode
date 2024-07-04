package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 964. Least Operators to Express Number.
 */
class Problem0964 extends LeetcodeProblem {

    private int                         x;
    private final Map<Integer, Integer> f = new HashMap<>();

    int leastOpsExpressTarget(int _x, int _target) {
        x = _x;
        return dfs(_target);
    }

    private int dfs(int _v) {
        if (x >= _v) {
            return Math.min(_v * 2 - 1, 2 * (x - _v));
        }
        if (f.containsKey(_v)) {
            return f.get(_v);
        }
        int k = 2;
        long y = (long) x * x;
        while (y < _v) {
            y *= x;
            k++;
        }
        int ans = k - 1 + dfs(_v - (int) (y / x));
        if (y - _v < _v) {
            ans = Math.min(ans, k + dfs((int) y - _v));
        }
        f.put(_v, ans);
        return ans;
    }

}
