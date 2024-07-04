package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1908. Game of Nim.
 */
class Problem1908 extends LeetcodeProblem {

    static class Solution {
        private final Map<Integer, Boolean> memo = new HashMap<>();
        private final int[]                 p    = new int[8];

        Solution() {
            p[0] = 1;
            for (int i = 1; i < 8; i++) {
                p[i] = p[i - 1] * 8;
            }
        }

        boolean nimGame(int[] _piles) {
            return dfs(_piles);
        }

        boolean dfs(int[] _piles) {
            int st = f(_piles);
            if (memo.containsKey(st)) {
                return memo.get(st);
            }
            for (int i = 0; i < _piles.length; i++) {
                for (int j = 1; j <= _piles[i]; j++) {
                    _piles[i] -= j;
                    if (!dfs(_piles)) {
                        _piles[i] += j;
                        memo.put(st, true);
                        return true;
                    }
                    _piles[i] += j;
                }
            }
            memo.put(st, false);
            return false;
        }

        int f(int[] _piles) {
            int st = 0;
            for (int i = 0; i < _piles.length; i++) {
                st += _piles[i] * p[i];
            }
            return st;
        }
    }

}
