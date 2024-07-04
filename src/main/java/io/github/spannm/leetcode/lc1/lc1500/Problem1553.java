package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1553. Minimum Number of Days to Eat N Oranges.
 */
class Problem1553 extends LeetcodeProblem {

    private final Map<Integer, Integer> f = new HashMap<>();

    int minDays(int _n) {
        return dfs(_n);
    }

    private int dfs(int _n) {
        if (_n < 2) {
            return _n;
        }
        if (f.containsKey(_n)) {
            return f.get(_n);
        }
        int res = 1 + Math.min(_n % 2 + dfs(_n / 2), _n % 3 + dfs(_n / 3));
        f.put(_n, res);
        return res;
    }

}
