package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 939. Minimum Area Rectangle.
 */
class Problem0939 extends LeetcodeProblem {

    int minAreaRect(int[][] _points) {
        TreeMap<Integer, List<Integer>> d = new TreeMap<>();
        for (var p : _points) {
            int x = p[0];
            int y = p[1];
            d.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        }
        Map<Integer, Integer> pos = new HashMap<>();
        int ans = 1 << 30;
        for (var e : d.entrySet()) {
            int x = e.getKey();
            var ys = e.getValue();
            Collections.sort(ys);
            int n = ys.size();
            for (int i = 0; i < n; i++) {
                int y1 = ys.get(i);
                for (int j = i + 1; j < n; j++) {
                    int y2 = ys.get(j);
                    int p = y1 * 40001 + y2;
                    if (pos.containsKey(p)) {
                        ans = Math.min(ans, (x - pos.get(p)) * (y2 - y1));
                    }
                    pos.put(p, x);
                }
            }
        }
        return ans == 1 << 30 ? 0 : ans;
    }

}
