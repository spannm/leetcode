package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 464. Can I Win.
 */
class Problem0464 extends LeetcodeProblem {

    boolean canIWin(int _maxChoosableInteger, int _desiredTotal) {
        return (1 + _maxChoosableInteger) * _maxChoosableInteger / 2 >= _desiredTotal && dfs(0, 0, _maxChoosableInteger, _desiredTotal, new HashMap<>());
    }

    static boolean dfs(int state, int t, int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> _memo) {
        Boolean res = _memo.get(state);
        if (res == null) {
            res = false;
            for (int i = 1; i <= maxChoosableInteger; i++) {
                if (0 == ((state >> i) & 1)) {
                    if (t + i >= desiredTotal
                        || !dfs(state | 1 << i, t + i, maxChoosableInteger, desiredTotal, _memo)) {
                        res = true;
                        break;
                    }
                }
            }
            _memo.put(state, res);
        }
        return res;
    }

}
