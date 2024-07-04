package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Problem1244 extends LeetcodeProblem {

    static class Leaderboard {
        private final Map<Integer, Integer> d    = new HashMap<>();
        private final Map<Integer, Integer> rank = new TreeMap<>((a, b) -> b - a);

        Leaderboard() {
        }

        void addScore(int _playerId, int _score) {
            d.merge(_playerId, _score, Integer::sum);
            int newScore = d.get(_playerId);
            if (newScore != _score) {
                rank.merge(newScore - _score, -1, Integer::sum);
            }
            rank.merge(newScore, 1, Integer::sum);
        }

        int top(int _k) {
            int ans = 0;
            for (var e : rank.entrySet()) {
                int score = e.getKey();
                int cnt = e.getValue();
                cnt = Math.min(cnt, _k);
                ans += score * cnt;
                _k -= cnt;
                if (_k == 0) {
                    break;
                }
            }
            return ans;
        }

        void reset(int _playerId) {
            int score = d.remove(_playerId);
            if (rank.merge(score, -1, Integer::sum) == 0) {
                rank.remove(score);
            }
        }

    }
}
