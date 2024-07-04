package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2013 extends LeetcodeProblem {

    static class DetectSquares {
        private final Map<Integer, Map<Integer, Integer>> cnt = new HashMap<>();

        public void add(int[] _point) {
            int x = _point[0];
            int y = _point[1];
            cnt.computeIfAbsent(x, k -> new HashMap<>()).merge(y, 1, Integer::sum);
        }

        public int count(int[] _point) {
            int x1 = _point[0];
            int y1 = _point[1];
            if (!cnt.containsKey(x1)) {
                return 0;
            }
            int ans = 0;
            for (var e : cnt.entrySet()) {
                int x2 = e.getKey();
                if (x2 != x1) {
                    int d = x2 - x1;
                    Map<Integer, Integer> cnt1 = cnt.get(x1);
                    Map<Integer, Integer> cnt2 = e.getValue();
                    Integer mult1 = cnt2.getOrDefault(y1, 0);
                    Integer mult2 = cnt1.getOrDefault(y1 + d, 0);
                    Integer mult3 = cnt2.getOrDefault(y1 - d, 0);
                    ans += mult1 * mult2 * cnt2.getOrDefault(y1 + d, 0);
                    ans += mult1 * cnt1.getOrDefault(y1 - d, 0) * mult3;
                }
            }
            return ans;
        }

    }

}
