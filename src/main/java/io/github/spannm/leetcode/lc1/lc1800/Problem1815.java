package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1815. Maximum Number of Groups Getting Fresh Donuts.
 */
class Problem1815 extends LeetcodeProblem {

    private final Map<Long, Integer> f = new HashMap<>();
    private int                      size;

    int maxHappyGroups(int _batchSize, int[] _groups) {
        size = _batchSize;
        int ans = 0;
        long state = 0;
        for (int g : _groups) {
            int i = g % size;
            if (i == 0) {
                ans++;
            } else {
                state += 1L << i * 5;
            }
        }
        ans += dfs(state, 0);
        return ans;
    }

    private int dfs(long _state, int _mod) {
        if (f.containsKey(_state)) {
            return f.get(_state);
        }
        int res = 0;
        for (int i = 1; i < size; i++) {
            if ((_state >> i * 5 & 31) != 0) {
                int t = dfs(_state - (1L << i * 5), (_mod + i) % size);
                res = Math.max(res, t + (_mod == 0 ? 1 : 0));
            }
        }
        f.put(_state, res);
        return res;
    }

}
