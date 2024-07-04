package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2225. Find Players With Zero or One Losses.
 */
class Problem2225 extends LeetcodeProblem {

    List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int[] m : matches) {
            int a = m[0];
            int b = m[1];
            counts.putIfAbsent(a, 0);
            counts.compute(b, (k, v) -> v == null ? 1 : v + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int u = entry.getKey();
            int v = entry.getValue();
            if (v < 2) {
                ans.get(v).add(u);
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }

}
