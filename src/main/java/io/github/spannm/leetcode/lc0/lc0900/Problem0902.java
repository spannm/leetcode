package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 902. Numbers At Most N Given Digit Set.
 */
class Problem0902 extends LeetcodeProblem {

    private final int[]        a  = new int[12];
    private final int[][]      dp = new int[12][2];
    private final Set<Integer> s  = new HashSet<>();

    int atMostNGivenDigitSet(String[] _digits, int _n) {
        for (var e : dp) {
            Arrays.fill(e, -1);
        }
        for (String d : _digits) {
            s.add(Integer.parseInt(d));
        }
        int len = 0;
        while (_n > 0) {
            a[++len] = _n % 10;
            _n /= 10;
        }
        return dfs(len, 1, true);
    }

    private int dfs(int _pos, int _lead, boolean _limit) {
        if (_pos <= 0) {
            return _lead ^ 1;
        }
        if (!_limit && _lead != 1 && dp[_pos][_lead] != -1) {
            return dp[_pos][_lead];
        }
        int ans = 0;
        int up = _limit ? a[_pos] : 9;
        for (int i = 0; i <= up; i++) {
            if (i == 0 && _lead == 1) {
                ans += dfs(_pos - 1, _lead, _limit && i == up);
            } else if (s.contains(i)) {
                ans += dfs(_pos - 1, 0, _limit && i == up);
            }
        }
        if (!_limit && _lead == 0) {
            dp[_pos][_lead] = ans;
        }
        return ans;
    }

}
