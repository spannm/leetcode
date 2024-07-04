package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3003. Maximize the Number of Partitions After Operations.
 */
class Problem3003 extends LeetcodeProblem {

    private final Map<List<Integer>, Integer> f = new HashMap<>();
    private String                            s;
    private int                               k;

    int maxPartitionsAfterOperations(String _s, int _k) {
        s = _s;
        k = _k;
        return dfs(0, 0, 1);
    }

    private int dfs(int _i, int _cur, int _t) {
        if (_i >= s.length()) {
            return 1;
        }
        List<Integer> key = List.of(_i, _cur, _t);
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int v = 1 << s.charAt(_i) - 'a';
        int nxt = _cur | v;
        int ans = Integer.bitCount(nxt) > k ? dfs(_i + 1, v, _t) + 1 : dfs(_i + 1, nxt, _t);
        if (_t > 0) {
            for (int j = 0; j < 26; j++) {
                nxt = _cur | 1 << j;
                if (Integer.bitCount(nxt) > k) {
                    ans = Math.max(ans, dfs(_i + 1, 1 << j, 0) + 1);
                } else {
                    ans = Math.max(ans, dfs(_i + 1, nxt, 0));
                }
            }
        }
        f.put(key, ans);
        return ans;
    }

}
